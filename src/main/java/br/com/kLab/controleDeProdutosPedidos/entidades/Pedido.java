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
	@Column
	private Integer numero;

	/**
	 * Data do Pedido.
	 */
	@Column
	private Date data;

	/**
	 * Associacao do Pedido com a tabela intermediaria {@link ProdutoPedido}.
	 */
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
	private List<ProdutoPedido> produtosPedido;

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
	 * @param produtosPedido
	 */
	public Pedido(Integer numero, Date data, List<ProdutoPedido> produtosPedido) {
		super();
		this.numero = numero;
		this.data = data;
		this.produtosPedido = produtosPedido;
	}

	/**
	 * Obtem o numero do Pedido.
	 *
	 * @return Integer
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * Define o numero do Pedido.
	 * 
	 * @param numero
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
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
	 * Obtem a lista de {@link ProdutoPedido}.
	 *
	 * @return List <{@link ProdutoPedido}>
	 */
	public List<ProdutoPedido> getProdutosPedido() {
		return produtosPedido;
	}

	/**
	 * Define a lista de {@link ProdutoPedido}.
	 *
	 * @param produtoPedidos
	 */
	public void setProdutoPedidos(List<ProdutoPedido> produtosPedido) {
		this.produtosPedido = produtosPedido;
	}

	/**
	 * Metodo usado para obter o valor total do Pedido, ou seja, retorna o somatorio
	 * do valor total de cada produto que equivale ao resultado da quantidade do
	 * produto multiplicado pelo valor da venda.
	 *
	 * @autor Carlos Pereira
	 *
	 * @return Double
	 */
	public Double calcularValorTotalPedido() {
		Double valorTotal = 0.0;

		if (this.produtosPedido != null) {
			for (ProdutoPedido produtoPedido : this.produtosPedido) {
				valorTotal += produtoPedido.valorTotalProduto();
			}
		}

		return valorTotal;
	}

	/**
	 * Gera um hash de um Pedido a partir do seu numero.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(numero);
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
		return Objects.equals(numero, other.numero);
	}

	/**
	 * Retorna uma representação em texto do Pedido.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [numero=");
		builder.append(numero);
		builder.append(", data=");
		builder.append(data);
		builder.append(", produtosPedido=");
		builder.append(produtosPedido);
		builder.append("]");
		return builder.toString();
	}

}
