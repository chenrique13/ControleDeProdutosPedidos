package br.com.kLab.controleDeProdutosPedidos.entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de teste para a entidade {@link ProdutoPedidoId}.
 */
class ProdutoPedidoIdTest {
	
	private ProdutoPedidoId produtoPedidoId;
	
	 /**
     * Inicializa os objetos necessarios antes de cada teste.
     */
    @BeforeEach
    public void executarAntesCadaTest() {
    	produtoPedidoId = new ProdutoPedidoId(1, 2);
    }
    
    /**
     * Testa o construtor sem argumentos.
     * Verifica se o objeto inicializa corretamente.
     */
    @Test
    public void testConstrutorSemArgumentos() {
        ProdutoPedidoId produtoPedidoId = new ProdutoPedidoId();
        assertNull(produtoPedidoId.getCodigoProduto());
        assertNull(produtoPedidoId.getNumeroPedido());
    }
    
    /**
     * Testa o construtor com argumentos.
     * Verifica se o objeto inicializa com os valores fornecidos.
     */
    @Test
    public void testConstrutorComArgumentos() {
        assertEquals(1, produtoPedidoId.getCodigoProduto());
        assertEquals(2, produtoPedidoId.getNumeroPedido());
    }

    /**
     * Testa os metodos get e set para o codigoProduto.
     * Verifica se obtem e define o codigoProduto corretamente.
     */
    @Test
    public void testGetSetCodigoProduto() {
    	produtoPedidoId.setCodigoProduto(3);;
    	assertEquals(3, produtoPedidoId.getCodigoProduto());
    }
    
    /**
     * Testa os metodos get e set para o numeroPedido.
     * Verifica se obtem e define o numeroPedido corretamente.
     */
    @Test
    public void testGetSetNumeroPedido() {
    	produtoPedidoId.setNumeroPedido(4);
    	assertEquals(4, produtoPedidoId.getNumeroPedido());
    }
    
    /**
     * Testa o metodo equals.
     * Verifica se dois objetos produtoPedidoId sao considerados iguais
     * com base no numero.
     */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEquals() {
		ProdutoPedidoId produtoPedidoId2 = new ProdutoPedidoId(1, 2);
		ProdutoPedidoId produtoPedidoId3 = new ProdutoPedidoId(3, 4);

		assertTrue(produtoPedidoId.equals(produtoPedidoId));
		assertFalse(produtoPedidoId.equals(null));
		assertFalse(produtoPedidoId.equals("OutraClasse"));
		assertTrue(produtoPedidoId.equals(produtoPedidoId2));
		assertFalse(produtoPedidoId.equals(produtoPedidoId3));
	}

    /**
     * Testa o metodo hashCode.
     * Verifica se o hashCode é gerado corretamente com base no produtoPedidoId.
     */
    @Test
    public void testHashCode() {
    	ProdutoPedidoId produtoPedidoId2 = new ProdutoPedidoId(1, 2);

        assertEquals(produtoPedidoId2.hashCode(), produtoPedidoId.hashCode());
    }

    /**
     * Testa o metodo toString.
     * Verifica se a representacao textual do produtoPedidoId é gerada corretamente.
     */
    @Test
    public void testToString() {
        String representacaoTextual = "ProdutoPedidoId [codigoProduto=1, numeroPedido=2]";
        assertEquals(representacaoTextual, produtoPedidoId.toString());
    }
    
}
