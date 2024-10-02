package br.com.kLab.controleDeProdutosPedidos.dtos.pedido;

import java.io.Serializable;
import java.util.List;

import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoPedidoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Pedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;

/**
 * Classe responsável por ser o modelo de dados na inclusão e alteração de
 * {@link Pedido} passando a lista de {@link Produto}.
 *
 * @autor Carlos Pereira
 *
 */
public class PedidoDto implements Serializable {

	private static final long serialVersionUID = -7411384023048568959L;

	List<ProdutoPedidoDto> produtos;

	public PedidoDto() {

	}

	public PedidoDto(List<ProdutoPedidoDto> produtos) {
		this.produtos = produtos;
	}

	public List<ProdutoPedidoDto> getProdutos() {
		return produtos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NovoPedidoDto [produtos=");
		builder.append(produtos);
		builder.append("]");
		return builder.toString();
	}

}
