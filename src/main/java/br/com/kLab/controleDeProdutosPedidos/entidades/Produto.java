package br.com.kLab.controleDeProdutosPedidos.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * Classe representando um produto do sistema de Controle de Produtos/Pedidos.
 * 
 * @author Carlos Pereira
 */

@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = -6768370942115004756L;

	/**
	 * Identificador unico do Produto.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer codigo;

	/**
	 * Descricao do Produto.
	 */
	@Column
	private String descricao;

	/**
	 * Preco do Produto.
	 */
	@Column
	private Double preco;

	/**
	 * Associacao obrigatoria do Produto com o {@link Departamento}
	 */
	@ManyToOne
	@JoinColumn(name = "codigoDepartamento", nullable = false)
	private Departamento departamento;

	/**
	 * Associacao do Produto com a tabela intermediaria {@link ProdutoPedido}.
	 */
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<ProdutoPedido> produtoPedidos;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public Produto() {

	}

	/**
	 * Construtor com todos os argumêntos.
	 *
	 * @param codigo
	 * @param descricao
	 * @param preco
	 */
	public Produto(Integer codigo, String descricao, Double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	/**
	 * Obtem o codigo do Produto.
	 *
	 * @return Integer
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * Define o codigo do Produto.
	 * 
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtem a descricao do Produto.
	 *
	 * @return String
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Define a descricao do Produto.
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * Obtem o preco do Produto.
	 *
	 * @return Double
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * Define o preco do Produto.
	 * 
	 * @param preco
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}

	/**
	 * Obtem o Departamento do Produto.
	 *
	 * @return {@link Departamento}
	 */
	public Departamento getDepartamento() {
		return departamento;
	}

	/**
	 * Define o Departamento do Produto.
	 * 
	 * @param departamento
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	
	/**
	 * Obtem a lista de {@link ProdutoPedido}.
	 *
	 * @return List <{@link ProdutoPedido}>
	 */
	public List<ProdutoPedido> getProdutoPedidos() {
		return produtoPedidos;
	}

	/**
	 * Define a lista de {@link ProdutoPedido}.
	 *
	 * @param produtoPedidos
	 */
	public void setProdutoPedidos(List<ProdutoPedido> produtoPedidos) {
		this.produtoPedidos = produtoPedidos;
	}

	/**
	 * Gera um hash de um Produto a partir do seu codigo.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	/**
	 * Verifica se um Produto e igual ao outro pelo codigo.
	 * 
	 * @param obj
	 * @return boolean
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto [codigo=");
		builder.append(codigo);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", preco=");
		builder.append(preco);
		builder.append(", departamento=");
		builder.append(departamento);
		builder.append(", produtoPedidos=");
		builder.append(produtoPedidos);
		builder.append("]");
		return builder.toString();
	}

}
