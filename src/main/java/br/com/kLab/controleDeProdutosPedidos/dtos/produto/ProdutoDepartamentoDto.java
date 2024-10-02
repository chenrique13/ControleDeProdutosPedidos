package br.com.kLab.controleDeProdutosPedidos.dtos.produto;

public class ProdutoDepartamentoDto {

	private Integer codigoProduto;
	
	private String descricaoProduto;

	private Double preco;

	public ProdutoDepartamentoDto() {
		
	}

	public ProdutoDepartamentoDto(Integer codigoProduto, String descricaoProduto, Double preco) {
		this.codigoProduto = codigoProduto;
		this.descricaoProduto = descricaoProduto;
		this.preco = preco;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public Double getPreco() {
		return preco;
	}

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
