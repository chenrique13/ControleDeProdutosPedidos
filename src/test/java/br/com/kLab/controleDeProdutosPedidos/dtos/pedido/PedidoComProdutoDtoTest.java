package br.com.kLab.controleDeProdutosPedidos.dtos.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoPedidoTotalDto;

/**
 * Testes unitarios para a classe {@link PedidoComProdutoDto}.
 */
public class PedidoComProdutoDtoTest {

	private PedidoComProdutoDto pedidoComProdutoDto;
	private List<ProdutoPedidoTotalDto> produtos;

	/**
	 * Inicializa os objetos necessarios antes de cada teste.
	 */
	@BeforeEach
	public void executarAntesCadaTest() {
		produtos = new ArrayList<>();
		produtos.add(new ProdutoPedidoTotalDto(1, "Chave de fenda", 2, 50.0, 100.0));
		produtos.add(new ProdutoPedidoTotalDto(2, "Alicate", 1, 75.0, 75.0));
		pedidoComProdutoDto = new PedidoComProdutoDto(12345, new Date(), 175.0, produtos);
	}

	/**
	 * Testa o construtor sem argumentos.
	 * Verifica se o objeto inicializa corretamente.
	 */
	@Test
	public void testConstrutorSemArgumentos() {
		PedidoComProdutoDto dto = new PedidoComProdutoDto();
		assertNull(dto.getNumeroPedido());
		assertNull(dto.getDataPedido());
		assertNull(dto.getTotalPedido());
		assertNull(dto.getProdutos());
	}

	/**
	 * Testa o construtor com argumentos. 
	 * Verifica se o objeto inicializa com os valores fornecidos.
	 */
	@Test
	public void testConstrutorComArgumentos() {
		assertEquals(12345, pedidoComProdutoDto.getNumeroPedido());
		assertNotNull(pedidoComProdutoDto.getDataPedido());
		assertEquals(175.0, pedidoComProdutoDto.getTotalPedido());
		assertEquals(produtos, pedidoComProdutoDto.getProdutos());
	}

	/**
	 * Testa o metodo getNumeroPedido. 
	 * Verifica se o numero do pedido é retornado corretamente.
	 */
	@Test
	public void testGetNumeroPedido() {
		assertEquals(12345, pedidoComProdutoDto.getNumeroPedido());
	}

	/**
	 * Testa o metodo getDataPedido.
	 * Verifica se a data do pedido é retornada corretamente.
	 */
	@Test
	public void testGetDataPedido() {
		assertNotNull(pedidoComProdutoDto.getDataPedido());
	}

	/**
	 * Testa o metodo getTotalPedido.
	 * Verifica se o total do pedido é retornado corretamente.
	 */
	@Test
	public void testGetTotalPedido() {
		assertEquals(175.0, pedidoComProdutoDto.getTotalPedido());
	}

	/**
	 * Testa o método getProdutos.
	 * Verifica se a lista de produtos é retornada corretamente.
	 */
	@Test
	public void testGetProdutos() {
		assertEquals(produtos, pedidoComProdutoDto.getProdutos());
		assertEquals(2, pedidoComProdutoDto.getProdutos().size());
	}

	 /**
     * Testa o metodo toString.
     * Verifica se a representacao textual do pedidoComProdutoDto é gerada corretamente.
     */
	@Test
	public void testToString() {
		String representacaoTextual = "PedidosComProdutoDto [numeroPedido=12345, dataPedido=" + pedidoComProdutoDto.getDataPedido()
				+ ", totalPedido=175.0, produtos=" + produtos + "]";
		assertEquals(representacaoTextual, pedidoComProdutoDto.toString());
	}
}