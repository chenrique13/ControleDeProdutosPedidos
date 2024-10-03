package br.com.kLab.controleDeProdutosPedidos.dtos.produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testes unitarios para a classe {@link ProdutoPedidoTotalDto}.
 */
public class ProdutoPedidoTotalDtoTest {

	private ProdutoPedidoTotalDto produtoPedidoTotalDto;

	/**
	 * Inicializa os objetos necessarios antes de cada teste.
	 */
	@BeforeEach
	public void executarAntesCadaTest() {
		produtoPedidoTotalDto = new ProdutoPedidoTotalDto(1, "Fone", 5, 50.0, 250.0);
	}

	/**
	 * Testa o construtor sem argumentos.
	 * Verifica se o objeto inicializa corretamente.
	 */
	@Test
	public void testConstrutorSemArgumentos() {
		ProdutoPedidoTotalDto dto = new ProdutoPedidoTotalDto();
		assertNull(dto.getCodigoProduto());
		assertNull(dto.getDescricaoProduto());
		assertNull(dto.getQuantidade());
		assertNull(dto.getValorVenda());
		assertNull(dto.getValorTotalProduto());
	}

	/**
	 * Testa o construtor com argumentos. 
	 * Verifica se o objeto inicializa com os valores fornecidos.
	 */
	@Test
	public void testConstrutorComArgumentos() {
		assertEquals(1, produtoPedidoTotalDto.getCodigoProduto());
		assertEquals("Fone", produtoPedidoTotalDto.getDescricaoProduto());
		assertEquals(5, produtoPedidoTotalDto.getQuantidade());
		assertEquals(50.0, produtoPedidoTotalDto.getValorVenda());
		assertEquals(250.0, produtoPedidoTotalDto.getValorTotalProduto());
	}

	/**
	 * Testa o metodo getCodigoProduto.
	 * Verifica se o codigo do produto é retornado corretamente.
	 */
	@Test
	public void testGetCodigoProduto() {
		assertEquals(1, produtoPedidoTotalDto.getCodigoProduto());
	}

	/**
	 * Testa o metodo getDescricaoProduto.
	 * Verifica se a descricao do produto é retornada corretamente.
	 */
	@Test
	public void testGetDescricaoProduto() {
		assertEquals("Fone", produtoPedidoTotalDto.getDescricaoProduto());
	}

	/**
	 * Testa o metodo getQuantidade.
	 * Verifica se a quantidade do produto é retornada corretamente.
	 */
	@Test
	public void testGetQuantidade() {
		assertEquals(5, produtoPedidoTotalDto.getQuantidade());
	}

	/**
	 * Testa o metodo getValorVenda.
	 * Verifica se o valor da venda do produto é retornado corretamente.
	 */
	@Test
	public void testGetValorVenda() {
		assertEquals(50.0, produtoPedidoTotalDto.getValorVenda());
	}

	/**
	 * Testa o metodo getValorTotalProduto.
	 * Verifica se o valor total do produto é retornado corretamente.
	 */
	@Test
	public void testGetValorTotalProduto() {
		assertEquals(250.0, produtoPedidoTotalDto.getValorTotalProduto());
	}

	 /**
     * Testa o metodo toString.
     * Verifica se a representacao textual do produtoPedidoTotalDto é gerada corretamente.
     */
	@Test
	public void testToString() {
		String representacaoTextual = "ProdutoPedidoTotalDto [codigoProduto=1, descricaoProduto=Fone, quantidade=5, valorVenda=50.0, valorTotalProduto=250.0]";
		assertEquals(representacaoTextual, produtoPedidoTotalDto.toString());
	}
}