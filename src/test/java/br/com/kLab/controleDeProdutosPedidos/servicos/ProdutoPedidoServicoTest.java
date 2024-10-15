package br.com.kLab.controleDeProdutosPedidos.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.kLab.controleDeProdutosPedidos.entidades.Departamento;
import br.com.kLab.controleDeProdutosPedidos.entidades.Pedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedidoId;
import br.com.kLab.controleDeProdutosPedidos.excecoes.ObjetoNaoEncontradoExcecao;
import br.com.kLab.controleDeProdutosPedidos.repositorios.ProdutoPedidoRepositorio;

/**
 * Classe de teste para da camada de serviço {@link ProdutoPedidoServico}.
 */
@ExtendWith(MockitoExtension.class)
class ProdutoPedidoServicoTest {

	@Mock
	private ProdutoPedidoRepositorio repositorioProdutoPedido;

	@InjectMocks
	private ProdutoPedidoServico produtoPedidoServico;

	private ProdutoPedidoId produtoPedidoId;
	private ProdutoPedido produtoPedidoMock;
	private Pedido pedido;
	private Produto produto;

	/**
	 * Inicializa os mocks, dados do repositório e objetos necessários antes de cada
	 * teste.
	 */
	@BeforeEach
	public void executarAntesCadaTest() {
		MockitoAnnotations.openMocks(this);

		Departamento departamento = new Departamento(1, "Ferramentas", new ArrayList<Produto>());
		pedido = new Pedido(1, Date.from(LocalDate.of(2024, 10, 2).atStartOfDay(ZoneId.systemDefault()).toInstant()),
				new ArrayList<ProdutoPedido>());
		produto = new Produto(1, "Martelo", 50.0, departamento, new ArrayList<ProdutoPedido>());
		produtoPedidoId = new ProdutoPedidoId(produto.getCodigo(), pedido.getNumero());

		produtoPedidoMock = new ProdutoPedido(produtoPedidoId, 2, produto.getPreco(), produto, pedido);
	}

	/**
	 * Testa a consulta do {@link ProdutoPedido} por id. 
	 * Configura o mock para retornar os dados simulados, chama o método da camada
	 * de serviço e realiza as verificações.
	 */
	@Test
	public void testDadoProdutoPedidoExistente_quandoConsultarPorId_entaoDeveRetornarProdutoPedido() {
		// Given: Configura os dados de entrada.
		given(repositorioProdutoPedido.findById(produtoPedidoId)).willReturn(Optional.of(produtoPedidoMock));

		// When: Executa o método a ser testado.
		ProdutoPedido resultado = produtoPedidoServico.consultarPorId(produtoPedidoId);

		// Then: Verifica os resultados.
		assertNotNull(resultado, "O produtoPedido não deve ser nulo");
		assertEquals(produtoPedidoId, resultado.getId(), "Os IDs devem ser iguais");
		assertEquals(2, resultado.getQuantidade(), "As quantidades devem ser iguais a 2");
		assertEquals(produto.getPreco(), resultado.getValorVenda(), "Os valores devem ser iguais");
		assertEquals(produto, resultado.getProduto(), "Os produtos devem ser iguais");
		assertEquals(pedido, resultado.getPedido(), "Os pedidos devem ser iguais");
	}

	/**
	 * Testa o lançamento de exceção {@link ObjetoNaoEncontradoExcecao]} quando o
	 * {@link ProdutoPedido} não for encontrado.
	 */
	@Test
	public void testDadoProdutoPedidoInexistente_quandoConsultarPorId_entaoDeveLancarExcecao() {
		// Given: Configura os dados de entrada.
		given(repositorioProdutoPedido.findById(produtoPedidoId)).willReturn(Optional.empty());

		// When: Executa o método a ser testado.
		// Then: Verifica se a exceção é lançada.
		ObjetoNaoEncontradoExcecao exception = assertThrows(ObjetoNaoEncontradoExcecao.class, () -> {
			produtoPedidoServico.consultarPorId(produtoPedidoId);
		}, "A exceção ObjetoNaoEncontradoExcecao não foi lançada.");

		assertEquals("ProdutoPedido com o Id " + produtoPedidoId + " não foi encontrado na base de dados do sistema!",
				exception.getMessage());
	}

	/**
	 * Testa a exclusão do {@link ProdutoPedido}.
	 */
	@Test
	public void testDadoProdutoPedidoExistente_quandoExcluirProdutoPedido_entaoDeveExcluirComSucesso() {
	    // Given: Configura os dados de entrada.
	    given(repositorioProdutoPedido.findById(produtoPedidoId)).willReturn(Optional.of(produtoPedidoMock));
	    doNothing().when(repositorioProdutoPedido).deleteById(produtoPedidoId);

	    // When: Executa o método a ser testado.
	    produtoPedidoServico.excluirProdutoPedido(produtoPedidoId);

	    // Then: Verifica se o método deleteById foi chamado.
	    verify(repositorioProdutoPedido, times(1)).deleteById(produtoPedidoId);
	}

	/**
	 * Testa o lançamento de exceção {@link ObjetoNaoEncontradoExcecao]} após a
	 * exclusão, quando o {@link ProdutoPedido} não for encontrado.
	 */
	@Test
	public void testDadoProdutoPedidoInexistente_quandoExcluirProdutoPedido_entaoDeveLancarExcecao() {
		// Given: Configura os dados de entrada.
		given(repositorioProdutoPedido.findById(produtoPedidoId)).willReturn(Optional.empty());

		// When: Executa o método a ser testado.
		// Then: Verifica se a exceção é lançada.
		ObjetoNaoEncontradoExcecao exception = assertThrows(ObjetoNaoEncontradoExcecao.class, () -> {
			produtoPedidoServico.excluirProdutoPedido(produtoPedidoId);
		}, "A exceção ObjetoNaoEncontradoExcecao não foi lançada.");

		assertEquals("ProdutoPedido com o Id " + produtoPedidoId + " não foi encontrado na base de dados do sistema!",
				exception.getMessage());
	}
	
}
