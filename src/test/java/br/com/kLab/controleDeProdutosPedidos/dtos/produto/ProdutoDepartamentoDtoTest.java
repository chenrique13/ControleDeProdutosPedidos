package br.com.kLab.controleDeProdutosPedidos.dtos.produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testes unitarios para a classe {@link ProdutoDepartamentoDto}.
 */
public class ProdutoDepartamentoDtoTest {

	private ProdutoDepartamentoDto produtoDepartamentoDto;

	/**
	 * Inicializa os objetos necessarios antes de cada teste.
	 */
	@BeforeEach
	public void executarAntesCadaTest() {
		produtoDepartamentoDto = new ProdutoDepartamentoDto(1, "Teclado", 100.0);
	}

	/**
	 * Testa o construtor sem argumentos.
	 * Verifica se o objeto inicializa corretamente.
	 */
	@Test
	public void testConstrutorSemArgumentos() {
		ProdutoDepartamentoDto dto = new ProdutoDepartamentoDto();
		assertNull(dto.getCodigoProduto());
		assertNull(dto.getDescricaoProduto());
		assertNull(dto.getPreco());
	}

	/**
	 * Testa o construtor com argumentos. 
	 * Verifica se o objeto inicializa com os valores fornecidos.
	 */
	@Test
	public void testConstrutorComArgumentos() {
		assertEquals(1, produtoDepartamentoDto.getCodigoProduto());
		assertEquals("Teclado", produtoDepartamentoDto.getDescricaoProduto());
		assertEquals(100.0, produtoDepartamentoDto.getPreco());
	}

	/**
	 * Testa o metodo getCodigoProduto. 
	 * Verifica se o codigo do produto é retornado corretamente.
	 */
	@Test
	public void testGetCodigoProduto() {
		assertEquals(1, produtoDepartamentoDto.getCodigoProduto());
	}

	/**
	 * Testa o metodo getDescricaoProduto. 
	 * Verifica se a descricao do produto é retornada corretamente.
	 */
	@Test
	public void testGetDescricaoProduto() {
		assertEquals("Teclado", produtoDepartamentoDto.getDescricaoProduto());
	}

	/**
	 * Testa o metodo getPreco.
	 * Verifica se o preco do produto é retornado corretamente.
	 */
	@Test
	public void testGetPreco() {
		assertEquals(100.0, produtoDepartamentoDto.getPreco());
	}

	 /**
     * Testa o metodo toString.
     * Verifica se a representacao textual do produtoDepartamentoDto é gerada corretamente.
     */
	@Test
	public void testToString() {
		String representacaoTextual = "ProdutoDepartamentoDto [codigoProduto=1, descricaoProduto=Teclado, preco=100.0]";
		assertEquals(representacaoTextual, produtoDepartamentoDto.toString());
	}
}