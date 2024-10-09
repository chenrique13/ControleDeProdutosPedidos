package br.com.kLab.controleDeProdutosPedidos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.kLab.controleDeProdutosPedidos.dtos.departamento.DepartamentoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Departamento;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import br.com.kLab.controleDeProdutosPedidos.servicos.DepartamentoServico;
import io.swagger.v3.oas.annotations.Operation;

/**
 * Classe responsável por ser o endpoint para operações relacionadas ao
 * {@link Departamento}.
 */
@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoControlador {

	@Autowired
	private DepartamentoServico servicoDepartamento;

	/**
	 * Endpoint responsavel por buscar um {@link Departamento} com produtos por um
	 * intervalo de codigo, ordenados pelo codigo do {@link Departamento} e
	 * descricao do {@link Produto}.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param codigoInicial
	 * @param codigoFinal
	 * @return ResponseEntity<List<{@link DepartamentoComProdutoDto}>>
	 */
	@Operation(summary = "Busca Departamentos por Codigo", description = "Buscar departamentos com produtos, "
			+ "filtrados pelo codigo inicial e final, ordenados pelo codigo do departamento e descricao do produto.")
	@GetMapping
	public ResponseEntity<List<DepartamentoComProdutoDto>> consultarDepartamentoComProdutoPorCodigo(
			@RequestParam Integer codigoInicial, @RequestParam Integer codigoFinal) {
		List<DepartamentoComProdutoDto> listaDepartamentoDto = servicoDepartamento
				.consultarDepartamentoComProdutoPorCodigo(codigoInicial, codigoFinal);

		if (listaDepartamentoDto != null) {
			return ResponseEntity.ok(listaDepartamentoDto);
		}
		return ResponseEntity.notFound().build();
	}

}
