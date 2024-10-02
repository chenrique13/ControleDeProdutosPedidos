package br.com.kLab.controleDeProdutosPedidos.servicos;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoPedidoTotalDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Pedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedido;
import br.com.kLab.controleDeProdutosPedidos.repositorios.PedidoRepositorio;

/**
 * Classe responsável por fornecer operações de negócio para a entidade
 * {@link Pedido}.
 */
@Service
public class PedidoServico {

	@Autowired
	private PedidoRepositorio repositorioPedido;

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
						consultarPorId((Integer) objeto[0]).calcularValorTotalPedido(),
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
					pedido.calcularValorTotalPedido(), listaProdutoPedidoTotalDto);

			return pedidosComProdutoDto;
		}
		return null;
	}

}
