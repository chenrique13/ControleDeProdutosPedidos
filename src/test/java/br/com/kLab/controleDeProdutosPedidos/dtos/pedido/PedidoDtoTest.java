package br.com.kLab.controleDeProdutosPedidos.dtos.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoPedidoDto;

/**
 * Testes unitsrios para a classe {@link PedidoDto}.
 */
public class PedidoDtoTest {

	private PedidoDto pedidoDto;
	private List<ProdutoPedidoDto> produtos;

	/**
	 * Inicializa os objetos necessarios antes de cada teste.
	 */
	@BeforeEach
	public void executarAntesCadaTest() {
		produtos = new ArrayList<>();
		produtos.add(new ProdutoPedidoDto(1, "Alicate", 2, 50.0));
		produtos.add(new ProdutoPedidoDto(2, "Chave de fenda", 1, 75.0));
		pedidoDto = new PedidoDto(produtos);
	}

	/**
	 * Testa o construtor sem argumentos.
	 * Verifica se o objeto inicializa corretamente.
	 */
	@Test
	public void testConstrutorSemArgumentos() {
		PedidoDto dto = new PedidoDto();
		assertNull(dto.getProdutos());
	}

	/**
	 * Testa o construtor com argumentos. 
	 * Verifica se o objeto inicializa com os valores fornecidos.
	 */
	@Test
	public void testConstrutorComArgumentos() {
		assertEquals(produtos, pedidoDto.getProdutos());
	}

	/**
	 * Testa o metodo getProdutos. 
	 * Verifica se a lista de ProdutoPedidoDto é retornada corretamente.
	 */
	@Test
	public void testGetProdutos() {
		assertEquals(produtos, pedidoDto.getProdutos());
		assertEquals(2, pedidoDto.getProdutos().size());
	}

	/**
	 * Testa o metodo toString.
	 * Verifica se a representação textual da classe é gerada corretamente.
	 */
	@Test
	public void testToString() {
		String representacaoTextual = "NovoPedidoDto [produtos=" + produtos + "]";
		assertEquals(representacaoTextual, pedidoDto.toString());
	}
}