package br.com.kLab.controleDeProdutosPedidos;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ControleDeProdutosPedidosApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void mainMethodRunsWithoutExceptions() {
        assertDoesNotThrow(() -> ControleDeProdutosPedidosApplication.main(new String[] {}));
    }
	
}
