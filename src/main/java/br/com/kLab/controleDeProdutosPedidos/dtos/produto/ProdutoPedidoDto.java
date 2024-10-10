package br.com.kLab.controleDeProdutosPedidos.dtos.produto;

import java.io.Serializable;

import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Classe responsável por ser o modelo de dados do {@link Produto} dentro do
 * {@link PedidoDto}.
 *
 * @autor Carlos Pereira
 *
 */
@Schema(description = "DTO que representa o modelo de dados dos produtos do pedido com o valor de venda e a quantidade.")
public class ProdutoPedidoDto implements Serializable {

	private static final long serialVersionUID = 7060356086753190869L;

	@Schema(description = "Código único do produto", example = "1")
	private Integer codigoProduto;

	@Schema(description = "Descrição do produto", example = "Chave de fenda")
	private String descricaoProduto;

	@Schema(description = "Quantidade do produto", example = "10")
	private Integer quantidade;

	@Schema(description = "Valor do Produto no instante que o Pedido foi realizado", example = "10.00")
	private Double valorVenda;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public ProdutoPedidoDto() {

	}

	/**
	 * Construtor com todos os argumentos.
	 *
	 * @param codigoProduto
	 * @param descricaoProduto
	 * @param quantidade
	 * @param valorVenda
	 */
	public ProdutoPedidoDto(Integer codigoProduto, String descricaoProduto, Integer quantidade, Double valorVenda) {
		this.codigoProduto = codigoProduto;
		this.descricaoProduto = descricaoProduto;
		this.quantidade = quantidade;
		this.valorVenda = valorVenda;
	}

	/**
	 * Obtem o codigo do Produto.
	 *
	 * @return Integer
	 */
	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	/**
	 * Obtem a descricao do Produto.
	 *
	 * @return String
	 */
	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	/**
	 * Obtem a quantidade do Produto.
	 *
	 * @return Integer
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * Obtem o valor da venda do Produto.
	 *
	 * @return Double
	 */
	public Double getValorVenda() {
		return valorVenda;
	}

	/**
	 * Retorna uma representação em texto do ProdutoPedidoDto.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProdutoPedidoTotalDto [codigoProduto=");
		builder.append(codigoProduto);
		builder.append(", descricaoProduto=");
		builder.append(descricaoProduto);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", valorVenda=");
		builder.append(valorVenda);
		builder.append("]");
		return builder.toString();
	}

}
