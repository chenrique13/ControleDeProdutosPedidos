package br.com.kLab.controleDeProdutosPedidos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;

/**
 * Classe responsável por conter métodos para realização de operações no banco de dados
 * da classe {@link Produto}.
 */
@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

}
