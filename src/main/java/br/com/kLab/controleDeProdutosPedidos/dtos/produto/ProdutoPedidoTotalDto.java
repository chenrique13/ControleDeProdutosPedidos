package br.com.kLab.controleDeProdutosPedidos.dtos.produto;

import java.io.Serializable;

import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;

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

	/**
	 * Codigo do Produto.
	 */
	private Integer codigoProduto;

	/**
	 * Descricao do Produto.
	 */
	private String descricaoProduto;

	/**
	 * Quantidade do Produto dentro do Pedido.
	 */
	private Integer quantidade;

	/**
	 * Valor do Produto no instante que o Pedido foi realizado.
	 */
	private Double valorVenda;

	/**
	 * Valor total do Produto no Pedido.
	 */
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
