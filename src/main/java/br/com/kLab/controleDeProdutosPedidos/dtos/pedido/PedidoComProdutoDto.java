package br.com.kLab.controleDeProdutosPedidos.dtos.pedido;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoPedidoTotalDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Pedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Classe responsável por ser o modelo de dados do {@link Pedido} com
 * {@link Produto}.
 *
 * @autor Carlos Pereira
 *
 */
@Schema(description = "DTO que representa o modelo de dados do pedido com os produtos e o valor total deles.")
public class PedidoComProdutoDto implements Serializable {

	private static final long serialVersionUID = 6046418795414112757L;

	@Schema(description = "Número único do pedido", example = "1")
	private Integer numeroPedido;

	@Schema(description = "Data do pedido", example = "2024-01-01")
	private Date dataPedido;

	@Schema(description = "Valor total do pedido", example = "100.00")
	private Double totalPedido;

	@Schema(description = "Lista de produtos do pedido", implementation = ProdutoPedidoTotalDto.class)
	private List<ProdutoPedidoTotalDto> produtos;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public PedidoComProdutoDto() {

	}

	/**
	 * Construtor com todos os argumentos.
	 * 
	 * @param numeroPedido
	 * @param dataPedido
	 * @param produtos
	 */
	public PedidoComProdutoDto(Integer numeroPedido, Date dataPedido, List<ProdutoPedidoTotalDto> produtos) {
		this.numeroPedido = numeroPedido;
		this.dataPedido = dataPedido;
		this.produtos = produtos;
		this.totalPedido = getTotalPedido();
	}

	/**
	 * Obtem o numero do Pedido.
	 *
	 * @return Integer
	 */
	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	/**
	 * Obtem a data do Pedido
	 * 
	 * @return Date
	 */
	public Date getDataPedido() {
		return dataPedido;
	}

	/**
	 * Obtem o valor total do pedido a partir da lista de produtos
	 * 
	 * @return Double
	 */
	public Double getTotalPedido() {
		Double valorTotal = 0.0;

		if (this.produtos != null) {
			for (ProdutoPedidoTotalDto produtoPedido : this.produtos) {
				valorTotal += produtoPedido.getValorTotalProduto();
			}
		}
		return valorTotal;
	}

	/**
	 * Obtem a lista de {@link ProdutoPedidoTotalDto}.
	 *
	 * @return List<{@link ProdutoPedidoTotalDto}>
	 */
	public List<ProdutoPedidoTotalDto> getProdutos() {
		return produtos;
	}

	/**
	 * Retorna uma representação em texto do PedidoComProdutoDto.
	 * 
	 * @return String
	 */
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
