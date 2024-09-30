package br.com.kLab.controleDeProdutosPedidos.entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

/**
 * Classe para a criacao de um id para a classe {@link ProdutoPedido} no sistema
 * de Controle de Produtos/Pedidos.
 * 
 * @author Carlos Pereira
 */

@Embeddable
public class ProdutoPedidoId implements Serializable {

	private static final long serialVersionUID = -8266595561096853505L;
	/**
	 * Identificador unico do {@link Produto}.
	 */
	private Integer codigoProduto;

	/**
	 * Identificador unico do {@link Pedido}.
	 */
	private Integer numeroPedido;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public ProdutoPedidoId() {
	}

	/**
	 * Construtor com todos os argumêntos.
	 *
	 * @param codigoProduto
	 * @param numeroPedido
	 */
	public ProdutoPedidoId(Integer codigoProduto, Integer numeroPedido) {
		this.codigoProduto = codigoProduto;
		this.numeroPedido = numeroPedido;
	}

	/**
	 * Obtem o codigo do {@link Produto}.
	 *
	 * @return Integer
	 */
	public Integer getCodigoProduto() {
		return codigoProduto;
	}

	/**
	 * Define o codigo do {@link Produto}.
	 * 
	 * @param codigoProduto
	 */
	public void setCodigoProduto(Integer codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	/**
	 * Obtem o numero do {@link Pedido}.
	 *
	 * @return Integer
	 */
	public Integer getNumeroPedido() {
		return numeroPedido;
	}

	/**
	 * Define o numero do {@link Pedido}.
	 * 
	 * @param numeroPedido
	 */
	public void setNumeroPedido(Integer numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	/**
	 * Gera um hash de um ProdutoPedidoId a partir do codigo do {@link Produto} e o
	 * numero do {@link Pedido}.
	 * 
	 * @return int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(codigoProduto, numeroPedido);
	}

	/**
	 * Verifica se um ProdutoPedidoId e igual ao outro pelo codigo do
	 * {@link Produto} e o numero do {@link Pedido}.
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
		ProdutoPedidoId other = (ProdutoPedidoId) obj;
		return Objects.equals(codigoProduto, other.codigoProduto) && Objects.equals(numeroPedido, other.numeroPedido);
	}

	/**
	 * Retorna uma representação em texto do ProdutoPedidoId.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProdutoPedidoId [codigoProduto=");
		builder.append(codigoProduto);
		builder.append(", numeroPedido=");
		builder.append(numeroPedido);
		builder.append("]");
		return builder.toString();
	}

}
