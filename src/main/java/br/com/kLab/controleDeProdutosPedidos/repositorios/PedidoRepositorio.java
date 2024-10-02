package br.com.kLab.controleDeProdutosPedidos.repositorios;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.kLab.controleDeProdutosPedidos.entidades.Pedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;

/**
 * Classe responsável por conter métodos para realização de operações no banco de dados
 * da classe {@link Pedido}.
 */
@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, Integer> {

	/**
	 * Sql nativa usada para retornar uma lista de objetos com os atributos
	 * numeroPedido, dataPedido, codigoProduto, descricaoProduto, quantidade,
	 * valor_venda, valorTotalProduto, filtrados pela data inicial e final do
	 * {@link Pedido} e ordenados pelo numero do {@link Pedido} e codigo do
	 * {@link Produto}.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param dataInicial
	 * @param dataFinal
	 * @return List<Object[]>
	 */
	@Query(value= "SELECT ped.numero as numeroPedido, ped.data as dataPedido, prod.codigo as codigoProduto, "
			+ "prod.descricao as descricaoProduto, pp.quantidade, pp.valor_venda, "
			+ "pp.quantidade * pp.valor_venda as valorTotalProduto "
			+ "FROM pedido ped "
			+ "INNER JOIN produto_pedido pp "
			+ "ON pp.numero_pedido = ped.numero "
			+ "LEFT JOIN produto prod "
			+ "ON prod.codigo = pp.codigo_produto "
			+ "WHERE ped.data BETWEEN :dataInicial AND :dataFinal "
			+ "ORDER BY ped.numero, prod.codigo;", nativeQuery = true)
	List<Object[]> consultarPedidosPorData(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);
	
}
