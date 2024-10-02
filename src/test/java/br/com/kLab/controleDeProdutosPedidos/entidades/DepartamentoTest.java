package br.com.kLab.controleDeProdutosPedidos.entidades;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de teste para a entidade {@link Departamento}.
 */
public class DepartamentoTest {

    private Departamento departamento;
    private List<Produto> produtos;

    /**
     * Inicializa os objetos necessarios antes de cada teste.
     */
    @BeforeEach
    public void executarAntesCadaTest() {
        produtos = new ArrayList<>();
        departamento = new Departamento(1, "Construção", produtos);
    }

    /**
     * Testa o construtor sem argumentos.
     * Verifica se o objeto inicializa corretamente.
     */
    @Test
    public void testConstrutorSemArgumentos() {
        Departamento departamento = new Departamento();
        assertNull(departamento.getCodigo());
        assertNull(departamento.getDescricao());
        assertNull(departamento.getProdutos());
    }

    /**
     * Testa o construtor com argumentos.
     * Verifica se o objeto inicializa com os valores fornecidos.
     */
    @Test
    public void testConstrutorComArgumentos() {
        assertEquals(1, departamento.getCodigo());
        assertEquals("Construção", departamento.getDescricao());
        assertEquals(departamento.getProdutos(), produtos);
    }

    /**
     * Testa os metodos get e set para o codigo.
     * Verifica se obtem e define o codigo corretamente.
     */
    @Test
    public void testGetSetCodigo() {
        departamento.setCodigo(2);
        assertEquals(2, departamento.getCodigo());
    }

    /**
     * Testa os metodos get e set para a descricao.
     * Verifica se obtem e define a descricao corretamente.
     */
    @Test
    public void testGetSetDescricao() {
        departamento.setDescricao("Informática");
        assertEquals("Informática", departamento.getDescricao());
    }

    /**
     * Testa os metodos get e set para a lista de produtos.
     * Verifica se obtem e define a lista de produtos corretamente.
     */
    @Test
    public void testGetSetProdutos() {
        departamento.setProdutos(produtos);
        assertEquals(produtos, departamento.getProdutos());
    }

    /**
     * Testa o metodo equals.
     * Verifica se dois objetos Departamento sao considerados iguais
     * com base no codigo.
     */
    @SuppressWarnings("unlikely-arg-type")
	@Test
    public void testEquals() {
        Departamento departamento1 = new Departamento(1, "Construção", produtos);
        Departamento departamento2 = new Departamento(1, "Construção", produtos);
        Departamento departamento3 = new Departamento(2, "Roupas", produtos);

        assertTrue(departamento1.equals(departamento1));
        assertFalse(departamento1.equals(null));
        assertFalse(departamento1.equals("OutraClasse"));
        assertTrue(departamento1.equals(departamento2));
        assertFalse(departamento1.equals(departamento3));
    }

    /**
     * Testa o metodo hashCode.
     * Verifica se o hashCode é gerado corretamente com base no codigo.
     */
    @Test
    public void testHashCode() {
        Departamento departamento1 = new Departamento(1, "Construção", produtos);
        Departamento departamento2 = new Departamento(1, "Construção", produtos);

        assertEquals(departamento1.hashCode(), departamento2.hashCode());
    }

    /**
     * Testa o metodo toString.
     * Verifica se a representação textual do Departamento é gerada corretamente.
     */
    @Test
    public void testToString() {
        String representacaoTextual = "Departamento [codigo=1, descricao=Construção, produtos=[]]";
        assertEquals(representacaoTextual, departamento.toString());
    }
}
