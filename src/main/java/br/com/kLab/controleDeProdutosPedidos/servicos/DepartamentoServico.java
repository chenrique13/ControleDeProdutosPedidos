package br.com.kLab.controleDeProdutosPedidos.servicos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kLab.controleDeProdutosPedidos.dtos.departamento.DepartamentoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.repositorios.DepartamentoRepositorio;

@Service
public class DepartamentoServico {

	@Autowired
	private DepartamentoRepositorio repositorioDepartamento;

	public List<DepartamentoComProdutoDto> consultarDepartamentoComProdutoPorCodigo(Integer codigoInicial,
			Integer codigoFinal) {

		List<Object[]> consultaDepartamento = repositorioDepartamento
				.consultarDepartamentoComProdutoPorCodigo(codigoInicial, codigoFinal);

		List<DepartamentoComProdutoDto> listaDepartamentoDto = consultaDepartamento.stream()
				.map(resultado -> new DepartamentoComProdutoDto(((Integer) resultado[0]), (String) resultado[1],
						((Integer) resultado[2]), (String) resultado[3], (Double) resultado[4]))
				.collect(Collectors.toList());

		return listaDepartamentoDto;
	}

}
