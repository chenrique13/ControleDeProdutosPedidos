package br.com.kLab.controleDeProdutosPedidos.dtos.produto;

import java.io.Serializable;

import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;

/**
 * Classe responsável por ser o modelo de dados do {@link Produto} dentro do
 * {@link PedidoDto}.
 *
 * @autor Carlos Pereira
 *
 */
public class ProdutoPedidoDto implements Serializable {

	private static final long serialVersionUID = 7060356086753190869L;

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
