package br.com.kLab.controleDeProdutosPedidos.dtos.produto;

import java.io.Serializable;

import br.com.kLab.controleDeProdutosPedidos.dtos.departamento.DepartamentoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;

/**
 * Classe responsável por ser o modelo de dados do {@link Produto} dentro do
 * {@link DepartamentoComProdutoDto}.
 *
 * @autor Carlos Pereira
 *
 */
public class ProdutoDepartamentoDto implements Serializable {

	private static final long serialVersionUID = -5087991678434232022L;

	/**
	 * Codigo do Produto.
	 */
	private Integer codigoProduto;

	/**
	 * Descricao do Produto.
	 */
	private String descricaoProduto;

	/**
	 * Preco do Produto.
	 */
	private Double preco;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public ProdutoDepartamentoDto() {

	}

	/**
	 * Construtor com todos os argumentos.
	 *
	 * @param codigoProduto
	 * @param descricaoProduto
	 * @param preco
	 */
	public ProdutoDepartamentoDto(Integer codigoProduto, String descricaoProduto, Double preco) {
		this.codigoProduto = codigoProduto;
		this.descricaoProduto = descricaoProduto;
		this.preco = preco;
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
	 * Obtem o preco do Produto.
	 *
	 * @return String
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * Retorna uma representação em texto do ProdutoDepartamentoDto.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProdutoDepartamentoDto [codigoProduto=");
		builder.append(codigoProduto);
		builder.append(", descricaoProduto=");
		builder.append(descricaoProduto);
		builder.append(", preco=");
		builder.append(preco);
		builder.append("]");
		return builder.toString();
	}

}
