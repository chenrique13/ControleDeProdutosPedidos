package br.com.kLab.controleDeProdutosPedidos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kLab.controleDeProdutosPedidos.entidades.Departamento;

@Repository
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Integer> {

	@Query(value= "SELECT dp.codigo as codigoDepartamento, dp.descricao as descricaoDepartamento, "
			+ "p.codigo as codigoProduto, p.descricao as descicaoProduto, p.preco as precoProduto "
			+ "FROM departamento dp "
			+ "INNER JOIN produto p "
			+ "ON p.codigo_departamento = dp.codigo "
			+ "WHERE dp.codigo BETWEEN :codigoInicial AND :codigoFinal "
			+ "ORDER BY dp.codigo ASC, p.descricao ASC;", nativeQuery = true)
	List<Object[]> consultarDepartamentoComProdutoPorCodigo(@Param("codigoInicial") Integer codigoInicial,
			@Param("codigoFinal") Integer codigoFinal);
	
	List<Departamento> findByProdutosIsNotEmptyAndCodigoBetweenOrderByCodigoAscProdutosDescricaoAsc(Integer codigoInicial, Integer codigoFinal);
	
}
