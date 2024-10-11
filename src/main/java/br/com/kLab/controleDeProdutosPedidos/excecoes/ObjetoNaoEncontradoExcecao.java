package br.com.kLab.controleDeProdutosPedidos.excecoes;

/**
 * Exceção personalizada para ser lançada quando uma busca não retornar o
 * objeto.
 *
 * @author Carlos Pereira
 */
public class ObjetoNaoEncontradoExcecao extends RuntimeException {

	private static final long serialVersionUID = 5059591248525783147L;

	/**
	 * Construtor padrão.
	 */
	public ObjetoNaoEncontradoExcecao() {

	}

	/**
	 * Construtor com a mensagem da exceção.
	 */
	public ObjetoNaoEncontradoExcecao(String mensagem) {
		super(mensagem);
	}
}
