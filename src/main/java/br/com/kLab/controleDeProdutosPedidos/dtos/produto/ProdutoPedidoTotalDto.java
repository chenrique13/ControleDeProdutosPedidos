package br.com.kLab.controleDeProdutosPedidos.dtos.produto;

import java.io.Serializable;

import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Classe responsável por ser o modelo de dados do {@link Produto} com as
 * informacoes do valor que o pedido foi vendido unitariamente e com o total do
 * valor do produto dentro do {@link PedidoComProdutoDto}.
 *
 * @autor Carlos Pereira
 *
 */
public class ProdutoPedidoTotalDto implements Serializable {

	private static final long serialVersionUID = -6601561810759204070L;

	@Schema(description = "Código único do produto", example = "1")
	private Integer codigoProduto;

	@Schema(description = "Descrição do produto", example = "Chave de fenda")
	private String descricaoProduto;

	@Schema(description = "Quantidade do produto", example = "10")
	private Integer quantidade;

	@Schema(description = "Valor do Produto no instante que o Pedido foi realizado", example = "10.00")
	private Double valorVenda;

	@Schema(description = "Valor total do Produto (Quantidade * Valor da venda)", example = "100.00")
	private Double valorTotalProduto;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public ProdutoPedidoTotalDto() {

	}

	/**
	 * Construtor com todos os argumentos.
	 *
	 * @param codigoProduto
	 * @param descricaoProduto
	 * @param quantidade
	 * @param valorVenda
	 * @param valorTotalProduto
	 */
	public ProdutoPedidoTotalDto(Integer codigoProduto, String descricaoProduto, Integer quantidade, Double valorVenda,
			Double valorTotalProduto) {
		this.codigoProduto = codigoProduto;
		this.descricaoProduto = descricaoProduto;
		this.quantidade = quantidade;
		this.valorVenda = valorVenda;
		this.valorTotalProduto = valorTotalProduto;
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
	 * @return String
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * Obtem o valor da venda do Produto.
	 *
	 * @return String
	 */
	public Double getValorVenda() {
		return valorVenda;
	}

	/**
	 * Obtem o valor total do Produto.
	 *
	 * @return String
	 */
	public Double getValorTotalProduto() {
		return valorTotalProduto;
	}

	/**
	 * Retorna uma representação em texto do ProdutoPedidoTotalDto.
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
		builder.append(", valorTotalProduto=");
		builder.append(valorTotalProduto);
		builder.append("]");
		return builder.toString();
	}

}
