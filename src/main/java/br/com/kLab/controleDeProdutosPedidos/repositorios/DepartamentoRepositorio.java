package br.com.kLab.controleDeProdutosPedidos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kLab.controleDeProdutosPedidos.entidades.Departamento;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;

/**
 * Classe responsável por conter métodos para realização de operações no banco de dados
 * da classe {@link Departamento}.
 */
@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Integer> {

	/**
	 * Sql nativa usada para retornar uma lista de objetos com os atributos
	 * codigoDepartamento, descricaoDepartamento, codigoProduto, descicaoProduto
	 * e precoProduto, com a obrigatoriedade de {@link Departamento} com {@link Produto},
	 * filtrados pelo codigo inicial e final do {@link Departamento}
	 * e ordenados pelo codigo do {@link Departamento} e descricao do {@link Produto}.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param codigoInicial
	 * @param codigoFinal
	 * @return List<Object[]>
	 */
	@Query(value= "SELECT dp.codigo as codigoDepartamento, dp.descricao as descricaoDepartamento, "
			+ "p.codigo as codigoProduto, p.descricao as descicaoProduto, p.preco as precoProduto "
			+ "FROM departamento dp "
			+ "INNER JOIN produto p "
			+ "ON p.codigo_departamento = dp.codigo "
			+ "WHERE dp.codigo BETWEEN :codigoInicial AND :codigoFinal "
			+ "ORDER BY dp.codigo ASC, p.descricao ASC;", nativeQuery = true)
	List<Object[]> consultarDepartamentoComProdutoPorCodigo(@Param("codigoInicial") Integer codigoInicial,
			@Param("codigoFinal") Integer codigoFinal);
	
	/**
	 * Query method usada para retornar uma lista de objetos com os atributos
	 * codigoDepartamento, descricaoDepartamento, codigoProduto, descicaoProduto
	 * e precoProduto, com a obrigatoriedade de {@link Departamento} com {@link Produto},
	 * filtrados pelo codigo inicial e final do {@link Departamento}
	 e ordenados pelo codigo do {@link Departamento} e descricao do {@link Produto}.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param codigoInicial
	 * @param codigoFinal
	 * @return List<{@link Departamento}>
	 */
	List<Departamento> findByProdutosIsNotEmptyAndCodigoBetweenOrderByCodigoAscProdutosDescricaoAsc(Integer codigoInicial, Integer codigoFinal);
	
}
