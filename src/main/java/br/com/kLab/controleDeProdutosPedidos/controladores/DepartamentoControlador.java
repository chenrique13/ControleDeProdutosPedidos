package br.com.kLab.controleDeProdutosPedidos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.kLab.controleDeProdutosPedidos.dtos.departamento.DepartamentoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.excecoes.ObjetoNaoEncontradoExcecao;
import br.com.kLab.controleDeProdutosPedidos.servicos.DepartamentoServico;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoControlador {

	@Autowired
	private DepartamentoServico servicoDepartamento;

	
	@GetMapping
	public ResponseEntity<List<DepartamentoComProdutoDto>> consultarDepartamentoComProdutoPorCodigo(
			@RequestParam Integer codigoInicial, @RequestParam Integer codigoFinal) throws ObjetoNaoEncontradoExcecao {
		List<DepartamentoComProdutoDto> listaDepartamentoDto = servicoDepartamento
				.consultarDepartamentoComProdutoPorCodigo(codigoInicial, codigoFinal);

		return ResponseEntity.ok(listaDepartamentoDto);
	}

}
