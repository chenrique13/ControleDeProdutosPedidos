package br.com.kLab.controleDeProdutosPedidos.dtos.departamento;

public class DepartamentoComProdutoDto {

	private Integer codigoDepartamento;

	private String descricaoDepartamento;

	private Integer codigoProduto;

	private String descricaoProduto;

	private Double precoProduto;

	public DepartamentoComProdutoDto() {

	}

	public DepartamentoComProdutoDto(Integer codigoDepartamento, String descricaoDepartamento, Integer codigoProduto,
			String descricaoProduto, Double precoProduto) {
		this.codigoDepartamento = codigoDepartamento;
		this.descricaoDepartamento = descricaoDepartamento;
		this.codigoProduto = codigoProduto;
		this.descricaoProduto = descricaoProduto;
		this.precoProduto = precoProduto;
	}

	public Integer getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public String getDescricaoDepartamento() {
		return descricaoDepartamento;
	}

	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartamentoComProdutoDto [codigoDepartamento=");
		builder.append(codigoDepartamento);
		builder.append(", descricaoDepartamento=");
		builder.append(descricaoDepartamento);
		builder.append(", codigoProduto=");
		builder.append(codigoProduto);
		builder.append(", descricaoProduto=");
		builder.append(descricaoProduto);
		builder.append(", precoProduto=");
		builder.append(precoProduto);
		builder.append("]");
		return builder.toString();
	}

}
