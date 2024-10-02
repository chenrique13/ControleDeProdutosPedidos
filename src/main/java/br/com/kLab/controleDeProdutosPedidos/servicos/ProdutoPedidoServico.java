package br.com.kLab.controleDeProdutosPedidos.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedidoId;
import br.com.kLab.controleDeProdutosPedidos.repositorios.ProdutoPedidoRepositorio;

/**
 * Classe responsável por fornecer operações de negócio para a entidade
 * {@link ProdutoPedido}.
 */
@Service
public class ProdutoPedidoServico {

	@Autowired
	private ProdutoPedidoRepositorio repositorioProdutoPedido;

	/**
	 * O metodo obtem um {@link ProdutoPedido} cadastrato no banco de dados, se
	 * existir.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param produtoPedidoId
	 * @return {@link ProdutoPedido}
	 */
	public ProdutoPedido consultarPorId(ProdutoPedidoId produtoPedidoId) {
		Optional<ProdutoPedido> Produtopedido = repositorioProdutoPedido.findById(produtoPedidoId);

		if (Produtopedido.isPresent()) {
			return Produtopedido.get();
		}
		return null;
	}

	/**
	 * Metodo usado para excluir por {@link ProdutoPedidoId} um
	 * {@link ProdutoPedido} no banco de dados.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param produtoPedidoId
	 */
	public void excluirProdutoPedido(ProdutoPedidoId produtoPedidoId) {
		ProdutoPedido produtoPedido = consultarPorId(produtoPedidoId);

		if (produtoPedido != null) {
			repositorioProdutoPedido.deleteById(produtoPedidoId);
		}
	}

}
