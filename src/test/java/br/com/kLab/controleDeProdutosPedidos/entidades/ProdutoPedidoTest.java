package br.com.kLab.controleDeProdutosPedidos.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de teste para a entidade {@link ProdutoPedido}.
 */
class ProdutoPedidoTest {

	private ProdutoPedido produtoPedido;

	private Departamento departamento;

	private Pedido pedido;

	private Produto produto;

	/**
	 * Inicializa os objetos necessarios antes de cada teste.
	 */
	@BeforeEach
	public void executarAntesCadaTest() {
		departamento = new Departamento(1, "Mercado", new ArrayList<>());
		pedido = new Pedido(1, Date.from(LocalDate.of(2024, 10, 2).atStartOfDay(ZoneId.systemDefault()).toInstant()),
				new ArrayList<>());
		produto = new Produto(2, "Uva", 5.00, departamento, new ArrayList<>());

		produtoPedido = new ProdutoPedido(new ProdutoPedidoId(produto.getCodigo(), pedido.getNumero()), 10,
				produto.getPreco(), produto, pedido);
	}

	/**
	 * Testa o construtor sem argumentos. Verifica se o objeto inicializa
	 * corretamente.
	 */
	@Test
	public void testConstrutorSemArgumentos() {
		ProdutoPedido produtoPedido = new ProdutoPedido();
		assertNull(produtoPedido.getId());
		assertNull(produtoPedido.getQuantidade());
		assertNull(produtoPedido.getValorVenda());
		assertNull(produtoPedido.getProduto());
		assertNull(produtoPedido.getPedido());
	}

	/**
	 * Testa o construtor com argumentos. Verifica se o objeto inicializa com os
	 * valores fornecidos.
	 */
	@Test
	public void testConstrutorComArgumentos() {
		assertEquals(new ProdutoPedidoId(produto.getCodigo(), pedido.getNumero()), produtoPedido.getId());
		assertEquals(10, produtoPedido.getQuantidade());
		assertEquals(5.00, produtoPedido.getValorVenda());
		assertEquals(produto, produtoPedido.getProduto());
		assertEquals(pedido, produtoPedido.getPedido());
	}
	
    /**
     * Testa os metodos get e set para o id.
     * Verifica se obtem e define o id corretamente.
     */
    @Test
    public void testGetSetId() {
    	produtoPedido.setId(new ProdutoPedidoId(1, 2));
    	assertEquals(new ProdutoPedidoId(1, 2), produtoPedido.getId());
    }
    
    /**
     * Testa os metodos get e set para o quantidade.
     * Verifica se obtem e define o quantidade corretamente.
     */
    @Test
    public void testGetSetQuantidade() {
    	produtoPedido.setQuantidade(10);
    	assertEquals(10, produtoPedido.getQuantidade());
    }
    
    /**
     * Testa os metodos get e set para o valor do produto quando foi vendido.
     * Verifica se obtem e define o valor do produto quando foi vendido corretamente.
     */
    @Test
    public void testGetSetValorVenda() {
    	produtoPedido.setValorVenda(5.00);
    	assertEquals(5.00, produtoPedido.getValorVenda());
    }
    
    /**
     * Testa os metodos get e set para o produto.
     * Verifica se obtem e define o produto corretamente.
     */
    @Test
	public void testGetSetProduto() {
		produtoPedido.setProduto(produto);
		assertEquals(produto, produtoPedido.getProduto());
	}
    
    /**
     * Testa os metodos get e set para o pedido.
     * Verifica se obtem e define o pedido corretamente.
     */
	@Test
	public void testGetSetPedido() {
		produtoPedido.setPedido(pedido);
		assertEquals(pedido, produtoPedido.getPedido());
	}
    
    /**
     * Testa os metodos get e set para o valor total do produto.
     * Verifica se obtem e define o valor total produto corretamente.
     */
	@Test
	public void testGetSetValorTotalProduto() {
		Double valorEsperado = 50.00;
		Double valorTotalProduto = produtoPedido.valorTotalProduto();

		assertEquals(valorEsperado, valorTotalProduto, "O valor total do produto está incorreto");
	}

    /**
     * Testa o metodo equals.
     * Verifica se dois objetos ProdutoPedido sao considerados iguais
     * com base no id.
     */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEquals() {
		Pedido pedido2 = new Pedido(2,
				Date.from(LocalDate.of(2024, 10, 3).atStartOfDay(ZoneId.systemDefault()).toInstant()),
				new ArrayList<>());
		Produto produto2 = new Produto(1, "Pera", 2.00, departamento, new ArrayList<>());
		ProdutoPedido produtoPedido2 = new ProdutoPedido(new ProdutoPedidoId(produto.getCodigo(), pedido.getNumero()),
				10, produto.getPreco(), produto, pedido);
		ProdutoPedido produtoPedido3 = new ProdutoPedido(new ProdutoPedidoId(produto2.getCodigo(), pedido2.getNumero()),
				10, produto2.getPreco(), produto2, pedido2);

		assertTrue(produtoPedido.equals(produtoPedido));
		assertFalse(produtoPedido.equals(null));
		assertFalse(produtoPedido.equals("OutraClasse"));
		assertTrue(produtoPedido.equals(produtoPedido2));
		assertFalse(produtoPedido.equals(produtoPedido3));
	}

    /**
     * Testa o metodo hashCode.
     * Verifica se o hashCode é gerado corretamente com base no id.
     */
	@Test
	public void testHashCode() {
		ProdutoPedido produtoPedido2 = new ProdutoPedido(new ProdutoPedidoId(produto.getCodigo(), pedido.getNumero()),
				10, produto.getPreco(), produto, pedido);

		assertEquals(produtoPedido2.hashCode(), produtoPedido.hashCode());
	}

    /**
     * Testa o metodo toString.
     * Verifica se a representacao textual do ProdutoPedido é gerada corretamente.
     */
    @Test
	public void testToString() {
		String representacaoTextual = "ProdutoPedido [id=ProdutoPedidoId [codigoProduto=2, numeroPedido=1],"
				+ " quantidade=10, valorVenda=5.0, produto=Produto [codigo=2, descricao=Uva, preco=5.0,"
				+ " departamento=Departamento [codigo=1, descricao=Mercado, produtos=[]], produtoPedidos=[]],"
				+ " pedido=Pedido [numero=1, data=Wed Oct 02 00:00:00 BRT 2024, produtosPedido=[]]]";
		assertEquals(representacaoTextual, produtoPedido.toString());
	}
    
}
