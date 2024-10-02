package br.com.kLab.controleDeProdutosPedidos.dtos.departamento;

import java.io.Serializable;
import java.util.List;

import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoDepartamentoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Departamento;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;

/**
 * Classe responsável por ser o modelo de dados do {@link Departamento} com
 * {@link Produto}.
 *
 * @autor Carlos Pereira
 *
 */
public class DepartamentoComProdutoDto implements Serializable {

	private static final long serialVersionUID = 8935947566609314372L;

	private Integer codigoDepartamento;

	private String descricaoDepartamento;

	private List<ProdutoDepartamentoDto> produtos;

	public DepartamentoComProdutoDto() {

	}

	public DepartamentoComProdutoDto(Integer codigoDepartamento, String descricaoDepartamento,
			List<ProdutoDepartamentoDto> produtos) {
		this.codigoDepartamento = codigoDepartamento;
		this.descricaoDepartamento = descricaoDepartamento;
		this.produtos = produtos;
	}

	public Integer getCodigoDepartamento() {
		return codigoDepartamento;
	}

	public String getDescricaoDepartamento() {
		return descricaoDepartamento;
	}

	public List<ProdutoDepartamentoDto> getProdutos() {
		return produtos;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DepartamentoComProdutoDto [codigoDepartamento=");
		builder.append(codigoDepartamento);
		builder.append(", descricaoDepartamento=");
		builder.append(descricaoDepartamento);
		builder.append(", produtos=");
		builder.append(produtos);
		builder.append("]");
		return builder.toString();
	}

}
