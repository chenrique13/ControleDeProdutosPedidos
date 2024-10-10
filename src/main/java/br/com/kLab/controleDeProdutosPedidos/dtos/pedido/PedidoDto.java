package br.com.kLab.controleDeProdutosPedidos.dtos.pedido;

import java.io.Serializable;
import java.util.List;

import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoPedidoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Pedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Classe responsável por ser o modelo de dados na inclusão e alteração de
 * {@link Pedido} passando a lista de {@link Produto}.
 *
 * @autor Carlos Pereira
 *
 */
public class PedidoDto implements Serializable {

	private static final long serialVersionUID = -7411384023048568959L;

	@Schema(description = "Lista de produtos do pedido", implementation = ProdutoPedidoDto.class)
	List<ProdutoPedidoDto> produtos;

	/**
	 * Construtor padrão sem argumentos.
	 */
	public PedidoDto() {

	}

	/**
	 * Construtor com todos os argumentos.
	 * 
	 * @param produtos
	 */
	public PedidoDto(List<ProdutoPedidoDto> produtos) {
		this.produtos = produtos;
	}

	/**
	 * Obtem a lista de {@link ProdutoPedidoDto}.
	 *
	 * @return List<{@link ProdutoPedidoDto}>
	 */
	public List<ProdutoPedidoDto> getProdutos() {
		return produtos;
	}

	/**
	 * Retorna uma representação em texto do PedidoDto.
	 * 
	 * @return String
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NovoPedidoDto [produtos=");
		builder.append(produtos);
		builder.append("]");
		return builder.toString();
	}

}
