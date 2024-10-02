package br.com.kLab.controleDeProdutosPedidos.servicos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kLab.controleDeProdutosPedidos.dtos.departamento.DepartamentoComProdutoDto;
import br.com.kLab.controleDeProdutosPedidos.dtos.produto.ProdutoDepartamentoDto;
import br.com.kLab.controleDeProdutosPedidos.entidades.Departamento;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import br.com.kLab.controleDeProdutosPedidos.repositorios.DepartamentoRepositorio;

/**
 * Classe responsável por fornecer operações de negócio para a entidade
 * {@link Departamento}.
 */
@Service
public class DepartamentoServico {

	@Autowired
	private DepartamentoRepositorio repositorioDepartamento;

	/**
	 * Metodo criado para retornar os {@link Departamento} com produto filtrados por
	 * um intervalo de codigos e ordenado por codigo do {@link Departamento} e a
	 * descricao do {@link Produto}.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param codigoInicial
	 * @param codigoFinal
	 * @return List<{@link DepartamentoComProdutoDto}>
	 */
	public List<DepartamentoComProdutoDto> consultarDepartamentoComProdutoPorCodigo(Integer codigoInicial,
			Integer codigoFinal) {
		List<Object[]> consultaDepartamento = repositorioDepartamento
				.consultarDepartamentoComProdutoPorCodigo(codigoInicial, codigoFinal);

		Map<Integer, DepartamentoComProdutoDto> mapaDepartamentoComProdutoDto = new HashMap<Integer, DepartamentoComProdutoDto>();

		for (Object[] resultado : consultaDepartamento) {
			Integer codigoDepartamento = (Integer) resultado[0];
			if (!mapaDepartamentoComProdutoDto.containsKey(codigoDepartamento)) {
				DepartamentoComProdutoDto departamentoDto = new DepartamentoComProdutoDto((Integer) resultado[0],
						(String) resultado[1], new ArrayList<ProdutoDepartamentoDto>());

				mapaDepartamentoComProdutoDto.put(codigoDepartamento, departamentoDto);
			}

			ProdutoDepartamentoDto produtoDepartamentoDto = new ProdutoDepartamentoDto((Integer) resultado[2],
					(String) resultado[3], (Double) resultado[4]);

			mapaDepartamentoComProdutoDto.get(codigoDepartamento).getProdutos().add(produtoDepartamentoDto);
		}

		List<DepartamentoComProdutoDto> listaDepartamentoComProdutoDto = new ArrayList<>(
				mapaDepartamentoComProdutoDto.values());

		return listaDepartamentoComProdutoDto;
	}

	/**
	 * Metodo criado para converter uma lista de {@link Departamento} em uma lista
	 * de {@link DepartamentoComProdutoDto} pode ser usado na consulta por Query
	 * method do {@link DepartamentoRepositorio}
	 *
	 * @autor Carlos Pereira
	 *
	 * @param departamentos
	 * @return List<{@link DepartamentoComProdutoDto}>
	 */
	public List<DepartamentoComProdutoDto> converterDepartamentosEmDtos(List<Departamento> departamentos) {
		List<DepartamentoComProdutoDto> listaDepartamentoDto = new ArrayList<>();

		for (Departamento departamento : departamentos) {
			List<ProdutoDepartamentoDto> listaProdutoDepartamentoDto = new ArrayList<ProdutoDepartamentoDto>();
			for (Produto produto : departamento.getProdutos()) {
				ProdutoDepartamentoDto produtoDepartamentoDto = new ProdutoDepartamentoDto(produto.getCodigo(),
						produto.getDescricao(), produto.getPreco());
				listaProdutoDepartamentoDto.add(produtoDepartamentoDto);
			}
			DepartamentoComProdutoDto departamentoDto = new DepartamentoComProdutoDto(departamento.getCodigo(),
					departamento.getDescricao(), listaProdutoDepartamentoDto);

			listaDepartamentoDto.add(departamentoDto);
		}
		return listaDepartamentoDto;
	}

}
