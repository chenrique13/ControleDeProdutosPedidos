package br.com.kLab.controleDeProdutosPedidos.entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

/**
 * Classe representando uma tabela intermediaria entre {@link Produto} e
 * {@link Pedido} do sistema de Controle de Produtos/Pedidos.
 * 
 * @author Carlos Pereira
 */

@Entity
@Table(name = "produtoPedido")
public class ProdutoPedido implements Serializable {

	private static final long serialVersionUID = -3323663556132724021L;

	/**
	 * Transforma o id em uma chave composta de forma abstrata.
	 */
	@EmbeddedId
	private ProdutoPedidoId id;

	/**
	 * Quantidade do {@link Produto} no {@link Pedido}.
	 */
	@Column
	private Integer quantidade;

	/**
	 * Valor de venda do {@link Produto} no {@link Pedido}.
	 */
	@Column
	private Double valorVenda;

	/**
	 * Associacao com o {@link Produto}.
	 */
	@ManyToOne
	@MapsId("codigoProduto")
	@JoinColumn(name = "codigoProduto")
	private Produto produto;

	/**
	 * Associacao com o {@link Pedido}.
	 */
	@ManyToOne
	@MapsId("numeroPedido")
	@JoinColumn(name = "numeroPedido")
	private Pedido pedido;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public ProdutoPedido() {

	}

	/**
	 * Construtor com todos os argumêntos.
	 *
	 * @param id
	 * @param quantidade
	 * @param valorVenda
	 * @param produto
	 * @param pedido
	 */
	public ProdutoPedido(ProdutoPedidoId id, Integer quantidade, Double valorVenda, Produto produto, Pedido pedido) {
		this.id = id;
		this.quantidade = quantidade;
		this.valorVenda = valorVenda;
		this.produto = produto;
		this.pedido = pedido;
	}

	/**
	 * Obtem o id do ProdutoPedido.
	 *
	 * @return ProdutoPedidoId
	 */
	public ProdutoPedidoId getId() {
		return id;
	}

	/**
	 * Define o id do ProdutoPedido.
	 * 
	 * @param id
	 */
	public void setId(ProdutoPedidoId id) {
		this.id = id;
	}

	/**
	 * Obtem a quantidade do ProdutoPedido.
	 *
	 * @return Integer
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * Define a quantidade do ProdutoPedido.
	 * 
	 * @param quantidade
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Obtem o valor da venda do ProdutoPedido.
	 *
	 * @return Double
	 */
	public Double getValorVenda() {
		return valorVenda;
	}

	/**
	 * Define o valor da venda do ProdutoPedido.
	 * 
	 * @param valorVenda
	 */
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	/**
	 * Obtem o produto do ProdutoPedido.
	 *
	 * @return Produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * Define o produto do ProdutoPedido.
	 * 
	 * @param produto
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	/**
	 * Obtem o pedido do ProdutoPedido.
	 *
	 * @return Pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * Define o pedido do ProdutoPedido.
	 * 
	 * @param pedido
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * Gera um hash de um ProdutoPedido a partir do seu id.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * Verifica se um ProdutoPedido e igual ao outro pelo id.
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
		ProdutoPedido other = (ProdutoPedido) obj;
		return Objects.equals(id, other.id);
	}

	/**
	 * Retorna uma representação em texto do ProdutoPedido.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProdutoPedido [id=");
		builder.append(id);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", valorVenda=");
		builder.append(valorVenda);
		builder.append(", produto=");
		builder.append(produto);
		builder.append(", pedido=");
		builder.append(pedido);
		builder.append("]");
		return builder.toString();
	}

}
