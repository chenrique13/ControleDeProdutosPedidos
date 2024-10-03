package br.com.kLab.controleDeProdutosPedidos.dtos.produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testes unitarios para a classe {@link ProdutoPedidoDto}.
 */
public class ProdutoPedidoDtoTest {

	private ProdutoPedidoDto produtoPedidoDto;

	/**
	 * Inicializa os objetos necessarios antes de cada teste.
	 */
	@BeforeEach
	public void executarAntesCadaTest() {
		produtoPedidoDto = new ProdutoPedidoDto(1, "Mouse", 5, 50.0);
	}

	/**
	 * Testa o construtor sem argumentos.
	 * Verifica se o objeto inicializa corretamente.
	 */
	@Test
	public void testConstrutorSemArgumentos() {
		ProdutoPedidoDto NovoProdutoPedidoDto = new ProdutoPedidoDto();
		assertNull(NovoProdutoPedidoDto.getCodigoProduto());
		assertNull(NovoProdutoPedidoDto.getDescricaoProduto());
		assertNull(NovoProdutoPedidoDto.getQuantidade());
		assertNull(NovoProdutoPedidoDto.getValorVenda());
	}

	/**
	 * Testa o construtor com argumentos. 
	 * Verifica se o objeto inicializa com os valores fornecidos.
	 */
	@Test
	public void testConstrutorComArgumentos() {
		assertEquals(1, produtoPedidoDto.getCodigoProduto());
		assertEquals("Mouse", produtoPedidoDto.getDescricaoProduto());
		assertEquals(5, produtoPedidoDto.getQuantidade());
		assertEquals(50.0, produtoPedidoDto.getValorVenda());
	}

	/**
	 * Testa o metodo getCodigoProduto.
	 * Verifica se o codigo do produto é retornado corretamente.
	 */
	@Test
	public void testGetCodigoProduto() {
		assertEquals(1, produtoPedidoDto.getCodigoProduto());
	}

	/**
	 * Testa o metodo getDescricaoProduto.
	 * Verifica se a descricao do produto é retornada corretamente.
	 */
	@Test
	public void testGetDescricaoProduto() {
		assertEquals("Mouse", produtoPedidoDto.getDescricaoProduto());
	}

	/**
	 * Testa o mdtodo getQuantidade.
	 * Verifica se a quantidade do produto é retornada corretamente.
	 */
	@Test
	public void testGetQuantidade() {
		assertEquals(5, produtoPedidoDto.getQuantidade());
	}

	/**
	 * Testa o metodo getValorVenda.
	 * Verifica se o valor da venda do produto é retornado corretamente.
	 */
	@Test
	public void testGetValorVenda() {
		assertEquals(50.0, produtoPedidoDto.getValorVenda());
	}

	 /**
     * Testa o metodo toString.
     * Verifica se a representacao textual do produtoPedidoDto é gerada corretamente.
     */
	@Test
	public void testToString() {
		String expected = "ProdutoPedidoTotalDto [codigoProduto=1, descricaoProduto=Mouse, quantidade=5, valorVenda=50.0]";
		assertEquals(expected, produtoPedidoDto.toString());
	}
}