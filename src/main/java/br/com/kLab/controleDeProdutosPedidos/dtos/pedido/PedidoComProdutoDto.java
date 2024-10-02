package br.com.kLab.controleDeProdutosPedidos.dtos.pedido;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoPedidoTotalDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Pedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;

/**
 * Classe responsável por ser o modelo de dados do {@link Pedido} com
 * {@link Produto}.
 *
 * @autor Carlos Pereira
 *
 */
public class PedidoComProdutoDto implements Serializable {

	private static final long serialVersionUID = 6046418795414112757L;

	private Integer numeroPedido;

	private Date dataPedido;

	private Double totalPedido;

	private List<ProdutoPedidoTotalDto> produtos;

	public PedidoComProdutoDto() {

	}

	public PedidoComProdutoDto(Integer numeroPedido, Date dataPedido, Double totalPedido,
			List<ProdutoPedidoTotalDto> produtos) {
		this.numeroPedido = numeroPedido;
		this.dataPedido = dataPedido;
		this.totalPedido = totalPedido;
		this.produtos = produtos;
	}

	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public Double getTotalPedido() {
		return totalPedido;
	}

	public List<ProdutoPedidoTotalDto> getProdutos() {
		return produtos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PedidosComProdutoDto [numeroPedido=");
		builder.append(numeroPedido);
		builder.append(", dataPedido=");
		builder.append(dataPedido);
		builder.append(", totalPedido=");
		builder.append(totalPedido);
		builder.append(", produtos=");
		builder.append(produtos);
		builder.append("]");
		return builder.toString();
	}

}
