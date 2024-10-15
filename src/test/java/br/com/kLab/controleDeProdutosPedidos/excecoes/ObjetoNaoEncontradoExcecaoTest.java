package br.com.kLab.controleDeProdutosPedidos.excecoes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de teste para a exceção {@link ObjetoNaoEncontradoExcecao}.
 */
class ObjetoNaoEncontradoExcecaoTest {

	private ObjetoNaoEncontradoExcecao excecao;
	
    /**
     * Inicializa os objetos necessarios antes de cada teste.
     */
    @BeforeEach
    public void executarAntesCadaTest() {
    	excecao = new ObjetoNaoEncontradoExcecao("Objeto não encontrado.");
    }
	
    /**
     * Testa o construtor sem argumentos.
     * Verifica se o objeto inicializa corretamente.
     */
    @Test
    public void testConstrutorSemArgumentos() {
        ObjetoNaoEncontradoExcecao objetoNaoEncontradoExcecao = new ObjetoNaoEncontradoExcecao();
        assertNull(objetoNaoEncontradoExcecao.getMessage());
    }
    
    /**
     * Testa o construtor com argumentos.
     * Verifica se o objeto inicializa com os valores fornecidos.
     */
    @Test
    public void testConstrutorComArgumentos() {
        assertEquals("Objeto não encontrado.", excecao.getMessage());
    }

}
