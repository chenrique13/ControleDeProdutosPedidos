package br.com.kLab.controleDeProdutosPedidos.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.kLab.controleDeProdutosPedidos.entidades.Departamento;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedido;
import br.com.kLab.controleDeProdutosPedidos.excecoes.ObjetoNaoEncontradoExcecao;
import br.com.kLab.controleDeProdutosPedidos.repositorios.ProdutoRepositorio;

/**
 * Classe de teste para da camada de serviço {@link ProdutoServico}.
 */
@ExtendWith(MockitoExtension.class)
class ProdutoServicoTest {

	@Mock
	private ProdutoRepositorio repositorioProduto;

	@InjectMocks
	private ProdutoServico produtoServico;

	private Integer idProduto;
	private Produto produtoMock;
	private Departamento departamento;
	
	/**
	 * Inicializa os mocks, dados do repositório e objetos necessários antes de cada
	 * teste.
	 */
	@BeforeEach
	public void executarAntesCadaTest() {
		MockitoAnnotations.openMocks(this);

		idProduto = 1;
		departamento =  new Departamento(1, "Ferramentas", new ArrayList<Produto>());
		produtoMock = new Produto(idProduto, "Martelo", 50.0, departamento, new ArrayList<ProdutoPedido>());
	}
	
	/**
	 * Testa a consulta do produto por id. 
	 * Configura o mock para retornar os dados simulados, chama o método da camada
	 * de serviço e realiza as verificações.
	 */
	@Test
	public void testDadoProdutoExistente_quandoConsultarPorId_entaoDeveRetornarProduto() {
		// Given: Configura os dados de entrada.
		given(repositorioProduto.findById(idProduto)).willReturn(Optional.of(produtoMock));

		// When: Executa o método a ser testado.
		Produto resultado = produtoServico.consultarPorId(idProduto);

		// Then: Verifica os resultados.
		assertNotNull(resultado);
		assertEquals(idProduto, resultado.getCodigo());
		assertEquals("Martelo", resultado.getDescricao());
		assertEquals(50.0, resultado.getPreco());
		assertEquals(departamento.getCodigo(), resultado.getDepartamento().getCodigo());
		assertEquals(departamento.getDescricao(), resultado.getDepartamento().getDescricao());
	}

	/**
	 * Testa o lançamento de exceção {@link ObjetoNaoEncontradoExcecao]} quando o
	 * produto não for encontrado.
	 */
	@Test
	public void testDadoProdutoNaoExistente_quandoConsultarPorId_entaoDeveLancarExcecao() {
		// Given: Configura os dados de entrada.
		given(repositorioProduto.findById(idProduto)).willReturn(Optional.empty());

		// When: Executa o método a ser testado.
		// Then: Verifica os resultados.
		ObjetoNaoEncontradoExcecao exception = assertThrows(ObjetoNaoEncontradoExcecao.class, () -> {
			produtoServico.consultarPorId(idProduto);
		});

		assertEquals("Produto com o Id "+ idProduto +" não foi encontrado na base de dados do sistema!", exception.getMessage());
	}
}
