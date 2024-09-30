package br.com.kLab.controleDeProdutosPedidos.entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
	private Integer codigo;

	/**
	 * Descricao do Produto.
	 */
	private String descricao;

	/**
	 * Preco do Produto.
	 */
	private Double preco;

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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo);
	}

	/**
	 * Retorna uma representação em texto do Produto.
	 * 
	 * @return String
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
		builder.append("]");
		return builder.toString();
	}

}
