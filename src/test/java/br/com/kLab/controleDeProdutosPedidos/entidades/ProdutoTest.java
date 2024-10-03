package br.com.kLab.controleDeProdutosPedidos.entidades;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de teste para a entidade {@link Produto}.
 */
class ProdutoTest {

	private Produto produto;
    private Departamento departamento;
    private List<ProdutoPedido> produtosPedido;

    /**
     * Inicializa os objetos necessarios antes de cada teste.
     */
    @BeforeEach
    public void executarAntesCadaTest() {
    	produtosPedido = new ArrayList<>();
        departamento = new Departamento(1, "Construção", new ArrayList<>());
        produto = new Produto(1, "Chave de Fenda", 10.5, departamento, produtosPedido);
    }

    /**
     * Testa o construtor sem argumentos.
     * Verifica se o objeto inicializa corretamente.
     */
    @Test
    public void testConstrutorSemArgumentos() {
    	Produto novoProduto = new Produto();
        assertNull(novoProduto.getCodigo());
        assertNull(novoProduto.getDescricao());
        assertNull(novoProduto.getPreco());
        assertNull(novoProduto.getDepartamento());
        assertNull(novoProduto.getProdutosPedido());
    }

    /**
     * Testa o construtor com argumentos.
     * Verifica se o objeto inicializa com os valores fornecidos.
     */
    @Test
    public void testConstrutorComArgumentos() {
        assertEquals(1, produto.getCodigo());
        assertEquals("Chave de Fenda", produto.getDescricao());
        assertEquals(10.5, produto.getPreco());
        assertEquals(departamento, produto.getDepartamento());
        assertEquals(produtosPedido, produto.getProdutosPedido());
    }

    /**
     * Testa os metodos get e set para o codigo.
     * Verifica se obtem e define o codigo corretamente.
     */
    @Test
    public void testGetSetCodigo() {
    	produto.setCodigo(2);
        assertEquals(2, produto.getCodigo());
    }

    /**
     * Testa os metodos get e set para a descricao.
     * Verifica se obtem e define a descricao corretamente.
     */
    @Test
    public void testGetSetDescricao() {
    	produto.setDescricao("Alicate");
        assertEquals("Alicate", produto.getDescricao());
    }
    
    /**
     * Testa os metodos get e set para a preco.
     * Verifica se obtem e define a preco corretamente.
     */
    @Test
    public void testGetSetPreco() {
    	produto.setPreco(20.0);
        assertEquals(20.0, produto.getPreco());
    }

    /**
     * Testa os metodos get e set para o departamento.
     * Verifica se obtem e define o departamento corretamente.
     */
    @Test
    public void testGetSetDepartamento() {
    	Departamento departamento2 = new Departamento(2, "Mercado", new ArrayList<>());
    	produto.setDepartamento(departamento2);
        assertEquals(departamento2, produto.getDepartamento());
    }

    /**
     * Testa os metodos get e set para a lista de produtosPedido.
     * Verifica se obtem e define a lista de produtosPedido corretamente.
     */
    @Test
   	public void testGetSetProdutosPedido() {
    	produto.setProdutosPedido(produtosPedido);
    	assertEquals(produtosPedido, produto.getProdutosPedido());
    }
    
    /**
     * Testa o metodo equals.
     * Verifica se dois objetos Produto sao considerados iguais
     * com base no codigo.
     */
    @SuppressWarnings("unlikely-arg-type")
	@Test
    public void testEquals() {
        Produto produto2 = new Produto(1, "Chave de Fenda", 10.5, departamento, produtosPedido);
        Produto produto3 = new Produto(2, "Alicate", 25.0, departamento, produtosPedido);

        assertTrue(produto.equals(produto));
        assertFalse(produto.equals(null));
        assertFalse(produto.equals("OutraClasse"));
        assertTrue(produto.equals(produto2));
        assertFalse(produto.equals(produto3));
    }

    /**
     * Testa o metodo hashCode.
     * Verifica se o hashCode é gerado corretamente com base no codigo.
     */
    @Test
    public void testHashCode() {
    	 Produto produto2 = new Produto(1, "Chave de Fenda", 10.5, departamento, produtosPedido);

        assertEquals(produto.hashCode(), produto2.hashCode());
    }

    /**
     * Testa o metodo toString.
     * Verifica se a representacao textual do Departamento é gerada corretamente.
     */
    @Test
    public void testToString() {
        String representacaoTextual = "Produto [codigo=1, descricao=Chave de Fenda, preco=10.5, departamento=Departamento [codigo=1, descricao=Construção, produtos=[]], produtosPedido=[]]";
        
        assertEquals(representacaoTextual, produto.toString());
    }

}
