package br.com.kLab.controleDeProdutosPedidos.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.kLab.controleDeProdutosPedidos.dtos.departamento.DepartamentoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoDepartamentoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Departamento;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedido;
import br.com.kLab.controleDeProdutosPedidos.excecoes.ObjetoNaoEncontradoExcecao;
import br.com.kLab.controleDeProdutosPedidos.repositorios.DepartamentoRepositorio;

/**
 * Classe de teste para da camada de serviço {@link DepartamentoServico}.
 */
@ExtendWith(MockitoExtension.class)
public class DepartamentoServicoTest {

	@Mock
	private DepartamentoRepositorio repositorioDepartamento;

	@InjectMocks
	private DepartamentoServico departamentoServico;

	private List<Object[]> dadosMock;
	private Departamento departamento;

	/**
	 * Inicializa os mocks, dados do repositório e objetos necessários antes de cada
	 * teste.
	 */
	@BeforeEach
	public void executarAntesCadaTest() {
		MockitoAnnotations.openMocks(this);

		dadosMock = Arrays.asList(new Object[] { 1, "Ferramentas", 101, "Martelo", 50.0 },
				new Object[] { 1, "Ferramentas", 102, "Chave de fenda", 20.0 },
				new Object[] { 2, "Mercado", 201, "Arroz", 10.0 });

		departamento = new Departamento(1, "Ferramentas", new ArrayList<Produto>());
		Produto produto1 = new Produto(101, "Martelo", 50.0, departamento, new ArrayList<ProdutoPedido>());
		Produto produto2 = new Produto(102, "Chave de fenda", 20.0, departamento, new ArrayList<ProdutoPedido>());
		departamento.setProdutos(Arrays.asList(produto1, produto2));
	}

	/**
	 * Testa a lista de departamento com produtos. 
	 * Configura o mock para retornar os dados simulados, chama o método da camada
	 * de serviço e realiza as verificações.
	 */
	@Test
	public void testDadoDepartamentosComProdutos_quandoConsultarDepartamentosPorCodigo_entaoDeveRetornarListaDeDepartamentosComProdutos() {
		// Given: Configura os dados de entrada.
		given(repositorioDepartamento.consultarDepartamentoComProdutoPorCodigo(1, 2)).willReturn(dadosMock);

		// When: Executa o método a ser testado.
		List<DepartamentoComProdutoDto> resultado = departamentoServico.consultarDepartamentoComProdutoPorCodigo(1, 2);

		// Then: Verifica os resultados.
		assertNotNull(resultado);
		assertEquals(2, resultado.size(), "O numero de departamentos deve ser 2");

		DepartamentoComProdutoDto primeiroDepartamento = resultado.get(0);
		assertEquals(1, primeiroDepartamento.getCodigoDepartamento());
		assertEquals("Ferramentas", primeiroDepartamento.getDescricaoDepartamento());
		assertEquals(2, primeiroDepartamento.getProdutos().size(), "O departamento deve ter 2 produtos");

		ProdutoDepartamentoDto primeiroProduto = primeiroDepartamento.getProdutos().get(0);
		assertEquals(101, primeiroProduto.getCodigoProduto());
		assertEquals("Martelo", primeiroProduto.getDescricaoProduto());
		assertEquals(50.0, primeiroProduto.getPreco(), 0.01);
	}

	/**
	 * Testa o lançamento de exceção {@link ObjetoNaoEncontradoExcecao]} quando a
	 * lista de departamento com produtos for vazia. 
	 * Configura o mock para retornar os dados simulados, verifica se a exceção é 
	 * lançada quando não há departamentos e se a mensagem da exceção correspondente.
	 * 
	 */
	@Test
	public void testDadoNenhumDepartamento_quandoConsultarDepartamentosPorCodigo_entaoDeveLancarExcecao() {
		// Given: Configura os dados de entrada.
		given(repositorioDepartamento.consultarDepartamentoComProdutoPorCodigo(1, 2))
				.willReturn(Collections.emptyList());

		// When: Executa o método a ser testado.
		// Then: Verifica os resultados.
		ObjetoNaoEncontradoExcecao exception = assertThrows(ObjetoNaoEncontradoExcecao.class, () -> {
			departamentoServico.consultarDepartamentoComProdutoPorCodigo(1, 2);
		});

		assertEquals(
				"Nenhum departamento encontrado na base de dados do sistema no intervalo de códigos: Código inicial = 1, Código final = 2",
				exception.getMessage());
	}

	/**
	 * Testa a conversão de uma lista de {@link Departamento} para uma lista de {@link DepartamentoComProdutoDto}.
	 */
	@Test
	public void testDadoListaDeDepartamentos_quandoConverterDepartamentos_entaoDeveConverterParaDtos() {
		// Given: Configura os dados de entrada.
		List<Departamento> listaDepartamentos = Arrays.asList(departamento);

		// When: Executa o método a ser testado.
		List<DepartamentoComProdutoDto> resultado = departamentoServico
				.converterDepartamentosEmDtos(listaDepartamentos);

		// Then: Verifica os resultados.
		assertNotNull(resultado);
		assertEquals(1, resultado.size(), "O número de departamentos deve ser 1");

		DepartamentoComProdutoDto departamentoDto = resultado.get(0);
		assertEquals(1, departamentoDto.getCodigoDepartamento());
		assertEquals("Ferramentas", departamentoDto.getDescricaoDepartamento());

		List<ProdutoDepartamentoDto> listaProdutosDto = departamentoDto.getProdutos();
		assertEquals(2, listaProdutosDto.size(), "O departamento deve ter 2 produtos");

		ProdutoDepartamentoDto produtoDto1 = listaProdutosDto.get(0);
		assertEquals(101, produtoDto1.getCodigoProduto());
		assertEquals("Martelo", produtoDto1.getDescricaoProduto());
		assertEquals(50.0, produtoDto1.getPreco(), 0.01);

		ProdutoDepartamentoDto produtoDto2 = listaProdutosDto.get(1);
		assertEquals(102, produtoDto2.getCodigoProduto());
		assertEquals("Chave de fenda", produtoDto2.getDescricaoProduto());
		assertEquals(20.0, produtoDto2.getPreco(), 0.01);
	}
	
	/**
	 * Testa a lista de departamento com produtos vazia.
	 */
	@Test
	public void testDadoListaVaziaDeDepartamentos_quandoConverterDepartamentos_entaoDeveRetornarListaVazia() {
		// Given: Configura os dados de entrada.
		List<Departamento> listaVazia = Collections.emptyList();
		
		// When: Executa o método a ser testado.
		List<DepartamentoComProdutoDto> resultado = departamentoServico.converterDepartamentosEmDtos(listaVazia);
		
		// Then: Verifica os resultados.
		assertNotNull(resultado);
		assertTrue(resultado.isEmpty(), "A lista de departamentos deve estar vazia");
	}

}
