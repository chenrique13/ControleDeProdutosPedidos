package br.com.kLab.controleDeProdutosPedidos.dtos.departamento;

import java.io.Serializable;
import java.util.List;

import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoDepartamentoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Departamento;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Classe responsável por ser o modelo de dados do {@link Departamento} com
 * {@link Produto}.
 *
 * @autor Carlos Pereira
 *
 */
public class DepartamentoComProdutoDto implements Serializable {

	private static final long serialVersionUID = 8935947566609314372L;
	
	@Schema(description = "Código único do departamento", example = "1")
	private Integer codigoDepartamento;

	@Schema(description = "Descrição do departamento", example = "Ferramentas")
	private String descricaoDepartamento;

	@Schema(description = "Lista de produtos do departamento", implementation = ProdutoDepartamentoDto.class)
	private List<ProdutoDepartamentoDto> produtos;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public DepartamentoComProdutoDto() {

	}

	/**
	 * Construtor com todos os argumentos.
	 * 
	 * @param codigoDepartamento
	 * @param descricaoDepartamento
	 * @param produtos
	 */
	public DepartamentoComProdutoDto(Integer codigoDepartamento, String descricaoDepartamento,
			List<ProdutoDepartamentoDto> produtos) {
		this.codigoDepartamento = codigoDepartamento;
		this.descricaoDepartamento = descricaoDepartamento;
		this.produtos = produtos;
	}

	/**
	 * Obtem o codigo do departamento.
	 *
	 * @return Integer
	 */
	public Integer getCodigoDepartamento() {
		return codigoDepartamento;
	}

	/**
	 * Obtem a descricao do departamento
	 * 
	 * @return String
	 */
	public String getDescricaoDepartamento() {
		return descricaoDepartamento;
	}

	/**
	 * Obtem a lista de {@link ProdutoDepartamentoDto}.
	 *
	 * @return List<{@link ProdutoDepartamentoDto}>
	 */
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
