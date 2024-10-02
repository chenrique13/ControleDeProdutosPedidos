package br.com.kLab.controleDeProdutosPedidos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedido;
import br.com.kLab.controleDeProdutosPedidos.entidades.ProdutoPedidoId;

/**
 * Classe responsável por conter métodos para realização de operações no banco de dados
 * da classe {@link ProdutoPedido}.
 */
@Repository
public interface ProdutoPedidoRepositorio extends JpaRepository<ProdutoPedido, ProdutoPedidoId> {

}
