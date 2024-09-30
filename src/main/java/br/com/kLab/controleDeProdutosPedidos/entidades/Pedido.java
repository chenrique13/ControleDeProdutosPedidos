package br.com.kLab.controleDeProdutosPedidos.entidades;

import java.io.Serializable;
import java.util.Date;
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
 * Classe representando um pedido do sistema de Controle de Produtos/Pedidos.
 * 
 * @author Carlos Pereira
 */

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = -790964385791051861L;

	/**
	 * Identificador unico do Pedido.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero")
	private Integer numeroPedido;

	/**
	 * Data do Pedido.
	 */
	private Date data;

	/**
	 * Associacao do Pedido com a tabela intermediaria.
	 */
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ProdutoPedido> produtoPedidos;
	
	/**
	 * Construtor padrão sem argumentos.
	 */	
	public Pedido() {

	}

	/**
	 * Construtor com todos os argumêntos.
	 *
	 * @param numero
	 * @param data
	 */
	public Pedido(Integer numeroPedido, Date data) {
		this.numeroPedido = numeroPedido;
		this.data = data;
	}

	/**
	 * Obtem o numero do Pedido.
	 *
	 * @return Integer
	 */
	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	/**
	 * Define o numero do Pedido.
	 * 
	 * @param numero
	 */
	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	/**
	 * Obtem a data do Pedido.
	 *
	 * @return Date
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Define a data do Pedido.
	 * 
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Gera um hash de um Pedido a partir do seu numero.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(numeroPedido);
	}

	/**
	 * Verifica se um Pedido e igual ao outro pelo numero.
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
		Pedido other = (Pedido) obj;
		return Objects.equals(numeroPedido, other.numeroPedido);
	}

	/**
	 * Retorna uma representação em texto do Pedido.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [numeroPedido=");
		builder.append(numeroPedido);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}

}
