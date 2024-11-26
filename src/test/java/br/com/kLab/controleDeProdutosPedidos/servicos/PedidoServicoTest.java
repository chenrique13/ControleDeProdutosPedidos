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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.kLab.controleDeProdutosPedidos.dtos.pedido.PedidoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoPedidoTotalDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Departamento;
import br.com.kLab.controleDeProdutosPedidos.entidades.Pedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedidoId;
import br.com.kLab.controleDeProdutosPedidos.excecoes.ObjetoNaoEncontradoExcecao;
import br.com.kLab.controleDeProdutosPedidos.repositorios.PedidoRepositorio;

/**
 * Classe de teste para da camada de serviço {@link PedidoServico}.
 */
@ExtendWith(MockitoExtension.class)
class PedidoServicoTest {

	@Mock
	private PedidoRepositorio repositorioPedido;

	@InjectMocks
	private PedidoServico pedidoServico;

	private Pedido pedidoMock;
	private PedidoComProdutoDto pedidoComProdutoDtoMock;
	private Produto produto;
	private ProdutoPedido produtoPedido;
	private Date dataInicial;
	private Date dataFinal;
	
	/**
	 * Inicializa os mocks, dados do repositório e objetos necessários antes de cada
	 * teste.
	 */
	@BeforeEach
	public void executarAntesCadaTest() {
		MockitoAnnotations.openMocks(this);

		List<ProdutoPedido> listaProdutosPedido = new ArrayList<ProdutoPedido>();

		Departamento departamento = new Departamento(1, "Ferramentas", new ArrayList<Produto>());
		pedidoMock = new Pedido(1,
				Date.from(LocalDate.of(2024, 10, 2).atStartOfDay(ZoneId.systemDefault()).toInstant()),
				new ArrayList<ProdutoPedido>());
		produto = new Produto(1, "Martelo", 50.0, departamento, new ArrayList<ProdutoPedido>());
		ProdutoPedidoId produtoPedidoId = new ProdutoPedidoId(produto.getCodigo(), pedidoMock.getNumero());
		produtoPedido = new ProdutoPedido(produtoPedidoId, 2, produto.getPreco(), produto, pedidoMock);

		listaProdutosPedido.add(produtoPedido);
		pedidoMock.setProdutoPedidos(listaProdutosPedido);
		produto.setProdutosPedido(listaProdutosPedido);

		List<ProdutoPedidoTotalDto> listaProdutosPedidoTotal = new ArrayList<ProdutoPedidoTotalDto>();
		ProdutoPedidoTotalDto produtosPedidoTotalDto = new ProdutoPedidoTotalDto(produtoPedido.getProduto().getCodigo(),
				produtoPedido.getProduto().getDescricao(), produtoPedido.getQuantidade(), produtoPedido.getValorVenda(),
				produtoPedido.valorTotalProduto());
		listaProdutosPedidoTotal.add(produtosPedidoTotalDto);
				
		pedidoComProdutoDtoMock = new PedidoComProdutoDto(pedidoMock.getNumero(), pedidoMock.getData(),
				listaProdutosPedidoTotal);
		dataInicial = Date.from(LocalDate.of(2024, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
		dataFinal =  Date.from(LocalDate.of(2025, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
	}
	
	/**
	 * Testa a consulta do {@link Pedido} por id. 
	 * Configura o mock para retornar os dados simulados, chama o método da camada
	 * de serviço e realiza as verificações.
	 */
	@Test
	public void testDadoPedidoExistente_quandoConsultarPorId_entaoDeveRetornarPedido() {
		// Given: Configura os dados de entrada.
		given(repositorioPedido.findById(pedidoMock.getNumero())).willReturn(Optional.of(pedidoMock));

		// When: Executa o método a ser testado.
		Pedido resultado = pedidoServico.consultarPorId(pedidoMock.getNumero());

		// Then: Verifica os resultados.
		assertNotNull(resultado, "O Pedido não deve ser nulo");
		assertEquals(pedidoMock.getNumero(), resultado.getNumero(), "O número do Pedido deve ser 1.");
		assertEquals(pedidoMock.getData(), resultado.getData(), "A data do Pedido deve ser 2024-10-02.");
		assertEquals(pedidoMock.getProdutosPedido(), resultado.getProdutosPedido(), "Os produtosPedido devem ser iguais.");
	}
	
	/**
	 * Testa o lançamento de exceção {@link ObjetoNaoEncontradoExcecao]} quando o
	 * {@link Pedido} não for encontrado.
	 */
	@Test
	public void testDadoProdutoNaoExistente_quandoConsultarPorId_entaoDeveLancarExcecao() {
		// Given: Configura os dados de entrada.
		given(repositorioPedido.findById(pedidoMock.getNumero())).willReturn(Optional.empty());

		// When: Executa o método a ser testado.
		// Then: Verifica os resultados.
		ObjetoNaoEncontradoExcecao exception = assertThrows(ObjetoNaoEncontradoExcecao.class, () -> {
			pedidoServico.consultarPorId(pedidoMock.getNumero());
		}, "A exceção ObjetoNaoEncontradoExcecao não foi lançada.");

		assertEquals("Pedido com o Id "+ pedidoMock.getNumero() +" não foi encontrado na base de dados do sistema!", exception.getMessage());
	}
	
	/**
	 * Testa a consulta do {@link PedidoComProdutoDto} por id. 
	 * Configura o mock para retornar os dados simulados, chama o método da camada
	 * de serviço e realiza as verificações.
	 */
	@Test
	public void testDadoPedidoExistente_quandoConsultarPedidoPorIdDto_entaoDeveRetornarPedidoComProdutoDto() {
		// Given: Configura os dados de entrada.
		given(repositorioPedido.findById(pedidoComProdutoDtoMock.getNumeroPedido())).willReturn(Optional.of(pedidoMock));
		
		// When: Executa o método a ser testado.
		PedidoComProdutoDto resultado = pedidoServico.consultarPedidoPorIdDto(pedidoComProdutoDtoMock.getNumeroPedido());

		// Then: Verifica os resultados.
		assertNotNull(resultado, "O Pedido não deve ser nulo");
		assertEquals(pedidoComProdutoDtoMock.getNumeroPedido(), resultado.getNumeroPedido(), "O número do Pedido deve ser 1.");
		assertEquals(pedidoComProdutoDtoMock.getDataPedido(), resultado.getDataPedido(), "A data do Pedido deve ser 2024-10-02.");
		assertEquals(pedidoComProdutoDtoMock.getTotalPedido(), resultado.getTotalPedido(), "O valor total do pedido deve ser 100.0.");
	}
	
	/**
	 * Testa o lançamento de exceção {@link ObjetoNaoEncontradoExcecao]} quando o
	 * {@link Pedido} não for encontrado.
	 */
	@Test
	public void testDadoProdutoNaoExistente_quandoConsultarPedidoPorIdDto_entaoDeveLancarExcecao() {
		// Given: Configura os dados de entrada.
		given(repositorioPedido.findById(pedidoComProdutoDtoMock.getNumeroPedido())).willReturn(Optional.empty());

		// When: Executa o método a ser testado.
		// Then: Verifica os resultados.
		ObjetoNaoEncontradoExcecao exception = assertThrows(ObjetoNaoEncontradoExcecao.class, () -> {
			pedidoServico.consultarPedidoPorIdDto(pedidoComProdutoDtoMock.getNumeroPedido());
		}, "A exceção ObjetoNaoEncontradoExcecao não foi lançada.");

		assertEquals("Pedido com o Id "+ pedidoComProdutoDtoMock.getNumeroPedido() +" não foi encontrado na base de dados do sistema!", exception.getMessage());
	}
	
	/**
	 * Testa a consulta do {@link PedidoComProdutoDto} por datas. 
	 * Configura o mock para retornar os dados simulados, chama o método da camada
	 * de serviço e realiza as verificações.
	 */
	@Test
	public void testDadoPedidoExistente_quandoConsultarPedidosPorDatas_entaoDeveRetornarPedidoComProdutoDto() {
		// Given: Configura os dados de entrada.
		List<Object[]> pedidoComProdutoDtoMock = Arrays.asList(
				new Object[] { 1, dataInicial, 101, "Martelo", 2, 10.0, 20.0 },
				new Object[] { 1, dataInicial, 102, "Marreta", 1, 15.0, 15.0 },
				new Object[] { 2, dataFinal, 103, "Prego", 3, 5.0, 15.0 });

		given(repositorioPedido.consultarPedidosPorData(dataInicial, dataFinal)).willReturn(pedidoComProdutoDtoMock);

		// When: Executa o método a ser testado.
		List<PedidoComProdutoDto> pedidosRetornados = pedidoServico.consultarPedidosPorData(dataInicial, dataFinal);

		// Then: Verifica os resultados.
		assertNotNull(pedidosRetornados);
		assertEquals(2, pedidosRetornados.size());

		PedidoComProdutoDto primeiroPedido = pedidosRetornados.get(0);
		assertEquals(1, primeiroPedido.getNumeroPedido());
		assertEquals(2, primeiroPedido.getProdutos().size());

		PedidoComProdutoDto segundoPedido = pedidosRetornados.get(1);
		assertEquals(2, segundoPedido.getNumeroPedido());
		assertEquals(1, segundoPedido.getProdutos().size());

		ProdutoPedidoTotalDto martelo = primeiroPedido.getProdutos().get(0);
		assertEquals(101, martelo.getCodigoProduto());
		assertEquals("Martelo", martelo.getDescricaoProduto());
		assertEquals(2, martelo.getQuantidade());
		assertEquals(10.0, martelo.getValorVenda());
		assertEquals(20.0, martelo.getValorTotalProduto());

		ProdutoPedidoTotalDto marreta = primeiroPedido.getProdutos().get(1);
		assertEquals(102, marreta.getCodigoProduto());
		assertEquals("Marreta", marreta.getDescricaoProduto());
		assertEquals(1, marreta.getQuantidade());
		assertEquals(15.0, marreta.getValorVenda());
		assertEquals(15.0, marreta.getValorTotalProduto());

		ProdutoPedidoTotalDto prego = segundoPedido.getProdutos().get(0);
		assertEquals(103, prego.getCodigoProduto());
		assertEquals("Prego", prego.getDescricaoProduto());
		assertEquals(3, prego.getQuantidade());
		assertEquals(5.0, prego.getValorVenda());
		assertEquals(15.0, prego.getValorTotalProduto());
	}
	
	/**
	 * Testa o lançamento de exceção {@link ObjetoNaoEncontradoExcecao]} quando o
	 * {@link PedidoComProdutoDto} não for encontrado.
	 */
	@Test
	public void testDadoProdutoNaoExistente_quandoConsultarPedidosPorDatas_entaoDeveLancarExcecao() {
		// Given: Configura os dados de entrada.
		given(repositorioPedido.consultarPedidosPorData(dataInicial, dataFinal)).willReturn(new ArrayList<Object[]>());

		// When: Executa o método a ser testado.
		// Then: Verifica os resultados.
		ObjetoNaoEncontradoExcecao exception = assertThrows(ObjetoNaoEncontradoExcecao.class, () -> {
			pedidoServico.consultarPedidosPorData(dataInicial, dataFinal);
		}, "A exceção ObjetoNaoEncontradoExcecao não foi lançada.");

		assertEquals("Nenhum pedido entre as datas " + dataInicial + " e " + dataFinal
				+ " foi encontrado na base de dados do sistema!", exception.getMessage());
	}
	
	/**
	 * Testa a exclusão do {@link Pedido}.
	 */
	@Test
	public void testDadoPedidoExistente_quandoExcluirPedido_entaoDeveExcluirComSucesso() {
	    // Given: Configura os dados de entrada.
	    given(repositorioPedido.findById(pedidoMock.getNumero())).willReturn(Optional.of(pedidoMock));
	    doNothing().when(repositorioPedido).deleteById(pedidoMock.getNumero());

	    // When: Executa o método a ser testado.
	    pedidoServico.excluirPedido(pedidoMock.getNumero());

	    // Then: Verifica se o método deleteById foi chamado.
	    verify(repositorioPedido, times(1)).deleteById(pedidoMock.getNumero());
	}

	/**
	 * Testa o lançamento de exceção {@link ObjetoNaoEncontradoExcecao]} após a
	 * exclusão, quando o {@link Pedido} não for encontrado.
	 */
	@Test
	public void testDadoPedidoInexistente_quandoExcluirPedido_entaoDeveLancarExcecao() {
		// Given: Configura os dados de entrada.
		given(repositorioPedido.findById(pedidoMock.getNumero())).willReturn(Optional.empty());

		// When: Executa o método a ser testado.
		// Then: Verifica se a exceção é lançada.
		ObjetoNaoEncontradoExcecao exception = assertThrows(ObjetoNaoEncontradoExcecao.class, () -> {
			pedidoServico.excluirPedido(pedidoMock.getNumero());
		}, "A exceção ObjetoNaoEncontradoExcecao não foi lançada.");

		assertEquals("ProdutoPedido com o Id " + pedidoMock.getNumero() + " não foi encontrado na base de dados do sistema!",
				exception.getMessage());
	}
	
    @Test
    public void testDadoPedido_quandoSalvarPedido_entaoDeveRetornarPedido() {
    	// Given: Configura os dados de entrada.
        given(repositorioPedido.save(pedidoMock)).willReturn(pedidoMock);

        // When: Chama o método a ser testado
        Pedido pedidoSalvo = pedidoServico.salvarPedido(pedidoMock);

        // Then: Verifica se o pedido foi salvo corretamente
        assertNotNull(pedidoSalvo);
        assertEquals(pedidoMock.getNumero(), pedidoSalvo.getNumero());
        assertEquals(pedidoMock.getData(), pedidoSalvo.getData());
        assertEquals(1, pedidoSalvo.getProdutosPedido().size());

        verify(repositorioPedido, times(1)).save(pedidoMock);
    }
}
