package br.com.kLab.controleDeProdutosPedidos.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de teste para a entidade {@link Pedido}.
 */
class PedidoTest {
	
	private Pedido pedido;
	
	private Date data;
	
	private List<ProdutoPedido> produtosPedido;
	
    /**
     * Inicializa os objetos necessarios antes de cada teste.
     */
    @BeforeEach
    public void executarAntesCadaTest() {
    	data = Date.from(LocalDate.of(2024, 10, 2).atStartOfDay(ZoneId.systemDefault()).toInstant());
    	produtosPedido = new ArrayList<>();
    	pedido = new Pedido(1, data, produtosPedido);
    }

    /**
     * Testa o construtor sem argumentos.
     * Verifica se o objeto inicializa corretamente.
     */
    @Test
    public void testConstrutorSemArgumentos() {
        Pedido pedido = new Pedido();
        assertNull(pedido.getNumero());
        assertNull(pedido.getData());
        assertNull(pedido.getProdutosPedido());
    }
    
    /**
     * Testa o construtor com argumentos.
     * Verifica se o objeto inicializa com os valores fornecidos.
     */
    @Test
    public void testConstrutorComArgumentos() {
        assertEquals(1, pedido.getNumero());
        assertEquals(data,pedido.getData());
        assertEquals(produtosPedido, pedido.getProdutosPedido());
    }
    
    /**
     * Testa os metodos get e set para o numero.
     * Verifica se obtem e define o numero corretamente.
     */
    @Test
    public void testGetSetNumero() {
    	pedido.setNumero(2);
    	assertEquals(2, pedido.getNumero());
    }
    
    /**
     * Testa os metodos get e set para o data.
     * Verifica se obtem e define o data corretamente.
     */
    @Test
	public void testGetSetData() {
		pedido.setData(data);
		assertEquals(data, pedido.getData());
	}
    
    /**
     * Testa os metodos get e set para a lista de produtosPedido.
     * Verifica se obtem e define a lista de produtosPedido corretamente.
     */
    @Test
   	public void testGetSetProdutosPedido() {
    	pedido.setProdutoPedidos(produtosPedido);
    	assertEquals(produtosPedido, pedido.getProdutosPedido());
    }

    /**
     * Testa o metodo calcularValorTotalPedido.
     * Verifica se o valor total do pedido corresponde ao valor esperado.
     */
	@Test
	public void testCalcularValorTotalPedido() {
		Departamento departamento = new Departamento(1, "Mercado", new ArrayList<>());
		Produto pera = new Produto(1, "Pera", 2.00, departamento, produtosPedido);
		Produto uva = new Produto(2, "Uva", 5.00, departamento, produtosPedido);

		ProdutoPedido produto1 = new ProdutoPedido(new ProdutoPedidoId(pedido.getNumero(), pera.getCodigo()), 5,
				pera.getPreco(), pera, pedido);
		ProdutoPedido produto2 = new ProdutoPedido(new ProdutoPedidoId(pedido.getNumero(), uva.getCodigo()), 10,
				uva.getPreco(), uva, pedido);

		produtosPedido.add(produto1);
		produtosPedido.add(produto2);
		pedido.setProdutoPedidos(produtosPedido);

		Double valorEsperado = 60.0;
		Double valorTotal = pedido.calcularValorTotalPedido();

		assertEquals(valorEsperado, valorTotal, "O valor total do pedido está incorreto");
	}
    
    /**
     * Testa o metodo equals.
     * Verifica se dois objetos Pedido sao considerados iguais
     * com base no numero.
     */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEquals() {
		Pedido pedido1 = new Pedido(1, data, produtosPedido);
		Pedido pedido2 = new Pedido(1, data, produtosPedido);
		Pedido pedido3 = new Pedido(2,Date.from(LocalDate.of(2024, 10, 3).
				atStartOfDay(ZoneId.systemDefault()).toInstant()), produtosPedido);

		assertTrue(pedido1.equals(pedido1));
		assertFalse(pedido1.equals(null));
		assertFalse(pedido1.equals("OutraClasse"));
		assertTrue(pedido1.equals(pedido2));
		assertFalse(pedido1.equals(pedido3));
	}

    /**
     * Testa o metodo hashCode.
     * Verifica se o hashCode é gerado corretamente com base no numero.
     */
    @Test
    public void testHashCode() {
        Pedido pedido1 = new Pedido(1, data, produtosPedido);
        Pedido pedido2 = new Pedido(1, data, produtosPedido);

        assertEquals(pedido1.hashCode(), pedido2.hashCode());
    }

    /**
     * Testa o metodo toString.
     * Verifica se a representação textual do Pedido é gerada corretamente.
     */
    @Test
    public void testToString() {
        String representacaoTextual = "Pedido [numero=1, data=Wed Oct 02 00:00:00 BRT 2024, produtosPedido=[]]";
        assertEquals(representacaoTextual, pedido.toString());
    }
    
}
