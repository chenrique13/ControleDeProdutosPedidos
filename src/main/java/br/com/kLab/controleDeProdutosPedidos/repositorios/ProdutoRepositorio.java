package br.com.kLab.controleDeProdutosPedidos.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {

}
