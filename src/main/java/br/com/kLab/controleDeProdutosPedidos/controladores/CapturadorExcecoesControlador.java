package br.com.kLab.controleDeProdutosPedidos.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.kLab.controleDeProdutosPedidos.excecoes.ObjetoNaoEncontradoExcecao;

/**
 * Classe para manipulação comum de exceções do projeto Usuários.
 * 
 * Esta classe define manipuladores de exceções do projeto Usuários.
 */
@RestControllerAdvice
public class CapturadorExcecoesControlador {

	/**
	 * Manipulador para exceções de objeto não encontrado.
	 * 
	 * Este método lida com exceções do tipo {@link ObjetoNaoEncontradoExcecao}, que
	 * ocorrem quando a busca não encontra o objeto.
	 *
	 * @autor Carlos Pereira
	 *
	 * @param excecao
	 * @return ResponseEntity String
	 */
	@ExceptionHandler(ObjetoNaoEncontradoExcecao.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> objetoNaoEncontrado(ObjetoNaoEncontradoExcecao excecao) {
		
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(excecao.getMessage());
	}
	
}
