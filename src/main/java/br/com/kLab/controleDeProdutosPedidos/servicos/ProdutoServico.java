package br.com.kLab.controleDeProdutosPedidos.servicos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kLab.controleDeProdutosPedidos.entidades.Produto;
import br.com.kLab.controleDeProdutosPedidos.repositorios.ProdutoRepositorio;

/**
 * Classe responsável por fornecer operações de negócio para a entidade
 * {@link Produto}.
 */
@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repositorioProduto;

	/**
	 * O metodo obtem um {@link Produto} cadastrato no banco de dados, se existir.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param idProduto
	 * @return {@link Produto}
	 */
	public Produto consultarPorId(Integer idProduto) {
		Optional<Produto> produto = repositorioProduto.findById(idProduto);

		if (produto.isPresent()) {
			return produto.get();
		}
		return null;
	}

}
