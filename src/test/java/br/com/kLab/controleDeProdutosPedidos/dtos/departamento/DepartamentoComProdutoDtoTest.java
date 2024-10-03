package br.com.kLab.controleDeProdutosPedidos.dtos.departamento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoDepartamentoDto;

/**
 * Testes unitarios para a classe {@link DepartamentoComProdutoDto}.
 */
public class DepartamentoComProdutoDtoTest {

	private DepartamentoComProdutoDto departamentoComProdutoDto;
	private List<ProdutoDepartamentoDto> produtos;

	/**
	 * Inicializa os objetos necessarios antes de cada teste.
	 */
	@BeforeEach
	public void executarAntesCadaTest() {
		produtos = new ArrayList<>();
		produtos.add(new ProdutoDepartamentoDto(1, "Chave de fenda", 100.0));
		produtos.add(new ProdutoDepartamentoDto(2, "Alicate", 200.0));

		departamentoComProdutoDto = new DepartamentoComProdutoDto(1, "Ferramentas", produtos);
	}

	/**
	 * Testa o construtor sem argumentos. Verifica se o objeto inicializa
	 * corretamente.
	 */
	@Test
	public void testConstrutorSemArgumentos() {
		DepartamentoComProdutoDto dto = new DepartamentoComProdutoDto();
		assertNull(dto.getCodigoDepartamento());
		assertNull(dto.getDescricaoDepartamento());
		assertNull(dto.getProdutos());
	}

	/**
	 * Testa o construtor com argumentos. Verifica se o objeto inicializa com os
	 * valores fornecidos.
	 */
	@Test
	public void testConstrutorComArgumentos() {
		assertEquals(1, departamentoComProdutoDto.getCodigoDepartamento());
		assertEquals("Ferramentas", departamentoComProdutoDto.getDescricaoDepartamento());
		assertEquals(produtos, departamentoComProdutoDto.getProdutos());
	}

	/**
	 * Testa o metodo getCodigoDepartamento.
	 * Verifica se obtem o codigo corretamente.
	 */
	@Test
	public void testGetCodigoDepartamento() {
		assertEquals(1, departamentoComProdutoDto.getCodigoDepartamento());
	}

	/**
	 * Testa o método getDescricaoDepartamento.
	 * Verifica se obtem a descricao corretamente.
	 */
	@Test
	public void testGetDescricaoDepartamento() {
		assertEquals("Ferramentas", departamentoComProdutoDto.getDescricaoDepartamento());
	}

	/**
	 * Testa o método getProdutos.
	 * Verifica se obtem a lista de ProdutoDepartamentoDto corretamente.
	 */
	@Test
	public void testGetProdutos() {
		assertEquals(produtos, departamentoComProdutoDto.getProdutos());
	}

	 /**
     * Testa o metodo toString.
     * Verifica se a representacao textual do departamentoComProdutoDto é gerada corretamente.
     */
	@Test
	public void testToString() {
		String representacaoTextual = "DepartamentoComProdutoDto [codigoDepartamento=1, descricaoDepartamento=Ferramentas, produtos=[ProdutoDepartamentoDto [codigoProduto=1, descricaoProduto=Chave de fenda, preco=100.0], ProdutoDepartamentoDto [codigoProduto=2, descricaoProduto=Alicate, preco=200.0]]]";
		assertEquals(representacaoTextual, departamentoComProdutoDto.toString());
	}
}