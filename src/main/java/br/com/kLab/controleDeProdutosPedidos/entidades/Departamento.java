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
import jakarta.persistence.OneToMany;

/**
 * Classe representando um departamento do sistema de Controle de
 * Produtos/Pedidos.
 * 
 * @author Carlos Pereira
 */

@Entity
public class Departamento implements Serializable{

	private static final long serialVersionUID = 102198882488252219L;

	/**
	 * Identificador unico do Departamento.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer codigo;
	
	/**
	 * Descricao do Departamento.
	 */
	@Column
	private String descricao;
	
	/**
	 * Associacao do Departamento com o {@link Produto}.
	 */
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	private List<Produto> produtos;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public Departamento() {
		
	}
	
	/**
	 * Construtor com todos os argumêntos.
	 *
	 * @param codigo
	 * @param descricao
	 */
	public Departamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	/**
	 * Obtem o codigo do Departamento.
	 *
	 * @return Integer
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * Define o codigo do Departamento.
	 * 
	 * @param codigo
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtem a descricao do Departamento.
	 *
	 * @return String
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Define a descricao do Departamento.
	 * 
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/**
	 * Obtem a lista de {@link Produto}.
	 *
	 * @return List <{@link Produto}>
	 */
	public List<Produto> getProdutos() {
		return produtos;
	}

	/**
	 * Define a lista de {@link Produto}.
	 *
	 * @param produtos
	 */
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	/**
	 * Gera um hash de um Departamento a partir do seu codigo.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	/**
	 * Verifica se um Departamento e igual ao outro pelo codigo.
	 * 
	 * @param obj
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(codigo, other.codigo);
	}

	/**
	 * Retorna uma representação em texto do Departamento.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Departamento [codigo=");
		builder.append(codigo);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", produtos=");
		builder.append(produtos);
		builder.append("]");
		return builder.toString();
	}
	
}
