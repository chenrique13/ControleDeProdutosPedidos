package br.com.kLab.controleDeProdutosPedidos.servicos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoDto;
import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoPedidoDto;
import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoPedidoTotalDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Pedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedidoId;
import br.com.kLab.controleDeProdutosPedidos.repositorios.PedidoRepositorio;

/**
 * Classe responsável por fornecer operações de negócio para a entidade
 * {@link Pedido}.
 */
@Service
public class PedidoServico {

	@Autowired
	private PedidoRepositorio repositorioPedido;

	@Autowired
	private ProdutoServico produtoServico;

	@Autowired
	private ProdutoPedidoServico produtoPedidoServico;

	/**
	 * O metodo obtem um {@link Pedido} cadastrato no banco de dados convertido para
	 * {@link PedidoComProdutoDto}, se existir.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param idPedido
	 * @return {@link PedidoComProdutoDto}
	 */
	public PedidoComProdutoDto consultarPedidoPorIdDto(Integer idPedido) {
		return converterParaPedidosComProdutoDto(consultarPorId(idPedido));
	}

	/**
	 * Metodo usado para obter uma lista de {@link PedidoComProdutoDto} no filtrados
	 * no intervalo de duas datas e ordenados por numero do {@link Pedido} e codigo
	 * do {@link Produto}
	 *
	 * @autor Carlos Pereira
	 *
	 * @param dataInicial
	 * @param dataFinal
	 * @return List<{@link PedidoComProdutoDto}>
	 */
	public List<PedidoComProdutoDto> consultarPedidosPorData(Date dataInicial, Date dataFinal) {

		List<Object[]> consultaPedidos = repositorioPedido.consultarPedidosPorData(dataInicial, dataFinal);

		Map<Integer, PedidoComProdutoDto> mapaPedidosComProdutoDto = new HashMap<Integer, PedidoComProdutoDto>();

		for (Object[] objeto : consultaPedidos) {
			Integer numeroPedido = (Integer) objeto[0];

			if (!mapaPedidosComProdutoDto.containsKey(numeroPedido)) {

				PedidoComProdutoDto pedidoDto = new PedidoComProdutoDto((Integer) objeto[0], (Date) objeto[1],
						new ArrayList<ProdutoPedidoTotalDto>());

				mapaPedidosComProdutoDto.put(numeroPedido, pedidoDto);
			}

			ProdutoPedidoTotalDto produtoDto = new ProdutoPedidoTotalDto((Integer) objeto[2], (String) objeto[3],
					(Integer) objeto[4], (Double) objeto[5], (Double) objeto[6]);

			mapaPedidosComProdutoDto.get(numeroPedido).getProdutos().add(produtoDto);
		}

		List<PedidoComProdutoDto> listaPedidosComProdutoDto = new ArrayList<>(mapaPedidosComProdutoDto.values());

		return listaPedidosComProdutoDto;
	}

	/**
	 * Metodo usado para inserir um {@link Pedido} no banco de dados e retornar um
	 * {@link PedidoComProdutoDto}.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param novoPedidoDto
	 * @return {@link PedidoComProdutoDto}
	 */
	@Transactional
	public PedidoComProdutoDto inserirPedido(PedidoDto novoPedidoDto) {
		Pedido pedido = new Pedido();
		pedido.setData(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

		Pedido pedidoSalvo = salvarPedido(pedido);
		pedidoSalvo.setProdutoPedidos(coletarListaProdutoPedido(pedidoSalvo, novoPedidoDto));

		return converterParaPedidosComProdutoDto(salvarPedido(pedidoSalvo));
	}

	/**
	 * Metodo usado para atualizar um {@link Pedido}, atualizando tambem os
	 * {@link ProdutoPedido} e retornar um {@link PedidoComProdutoDto}
	 *
	 * @autor Carlos Pereira
	 *
	 * @param idPedido
	 * @param pedidoDto
	 * @return {@link PedidoComProdutoDto}
	 */
	@Transactional
	public PedidoComProdutoDto atualizarPedido(Integer idPedido, PedidoDto pedidoDto) {
		List<ProdutoPedido> listaExclusaoProdutoPedido = new ArrayList<ProdutoPedido>();
		Pedido pedidosalvo = new Pedido();
		Pedido pedido = consultarPorId(idPedido);
		if (pedido != null) {
			pedido.setData(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

			List<ProdutoPedido> novaListaProdutoPedido = coletarListaProdutoPedido(pedido, pedidoDto);

			listaExclusaoProdutoPedido = pedido.getProdutosPedido().stream()
					.filter(produtoPedido -> !novaListaProdutoPedido.contains(produtoPedido))
					.collect(Collectors.toList());

			pedido.setProdutoPedidos(novaListaProdutoPedido);
			pedidosalvo = salvarPedido(pedido);
		}

		for (ProdutoPedido produtoPedido : listaExclusaoProdutoPedido) {
			produtoPedidoServico.excluirProdutoPedido(produtoPedido.getId());
		}

		return converterParaPedidosComProdutoDto(pedidosalvo);
	}

	/**
	 * Metodo usado para salvar um {@link Pedido} no banco de dados.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param pedido
	 * @return {@link Pedido}
	 */
	public Pedido salvarPedido(Pedido pedido) {
		return repositorioPedido.save(pedido);
	}

	/**
	 * Metodo usado para excluir por id um {@link Pedido} no banco de dados.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param idPedido
	 */
	public void excluirPedido(Integer idPedido) {
		Pedido pedido = consultarPorId(idPedido);

		if (pedido != null) {
			repositorioPedido.deleteById(pedido.getNumero());
		}
	}

	/**
	 * O metodo obtem um {@link Pedido} cadastrato no banco de dados, se existir.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param idPedido
	 * @return {@link Pedido}
	 */
	public Pedido consultarPorId(Integer idPedido) {
		Optional<Pedido> pedido = repositorioPedido.findById(idPedido);

		if (pedido.isPresent()) {
			return pedido.get();
		}
		return null;
	}

	/**
	 * Metodo usado para converter um {@link Pedido} em {@link PedidoComProdutoDto}.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param pedido
	 * @return {@link PedidoComProdutoDto}
	 */
	private PedidoComProdutoDto converterParaPedidosComProdutoDto(Pedido pedido) {
		if (pedido != null) {
			List<ProdutoPedidoTotalDto> listaProdutoPedidoTotalDto = new ArrayList<ProdutoPedidoTotalDto>();

			for (ProdutoPedido produtoPedido : pedido.getProdutosPedido()) {
				ProdutoPedidoTotalDto produtoPedidoTotalDto = new ProdutoPedidoTotalDto(
						produtoPedido.getProduto().getCodigo(), produtoPedido.getProduto().getDescricao(),
						produtoPedido.getQuantidade(), produtoPedido.getValorVenda(),
						produtoPedido.valorTotalProduto());

				listaProdutoPedidoTotalDto.add(produtoPedidoTotalDto);
			}

			PedidoComProdutoDto pedidosComProdutoDto = new PedidoComProdutoDto(pedido.getNumero(), pedido.getData(),
					listaProdutoPedidoTotalDto);

			return pedidosComProdutoDto;
		}
		return null;
	}

	/**
	 * Metodo usado para coletar uma lista de {@link ProdutoPedido} recebendo um
	 * {@link Pedido} e um {@link PedidoDto}, usado na criacao e alteracao de um
	 * pedido.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param pedido
	 * @param pedidoDto
	 * @return List<{@link ProdutoPedido}>
	 */
	private List<ProdutoPedido> coletarListaProdutoPedido(Pedido pedido, PedidoDto pedidoDto) {
		List<ProdutoPedido> listaProdutosPedido = new ArrayList<>();
		if (pedidoDto != null) {
			for (ProdutoPedidoDto produtoDto : pedidoDto.getProdutos()) {
				Produto produto = produtoServico.consultarPorId(produtoDto.getCodigoProduto());
				if (produto != null) {
					ProdutoPedido produtoPedido = new ProdutoPedido();
					ProdutoPedidoId id = new ProdutoPedidoId(produto.getCodigo(), pedido.getNumero());

					produto.setDescricao(produtoDto.getDescricaoProduto());

					produtoPedido.setId(id);
					produtoPedido.setQuantidade(produtoDto.getQuantidade());
					produtoPedido.setValorVenda(produtoDto.getValorVenda());
					produtoPedido.setProduto(produto);
					produtoPedido.setPedido(pedido);

					listaProdutosPedido.add(produtoPedido);
				}
			}
		}
		return listaProdutosPedido;
	}

}
