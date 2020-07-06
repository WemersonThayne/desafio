package br.com.desafio.exception;

/**
 * Exceção para Registro não encontrado do tipo {@link RuntimeException}.
 *
 * @author wemerson.vital
 */
public class RegistroNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	private transient String mensagem;

	public RegistroNaoEncontradoException() {
		super();
	}

	public RegistroNaoEncontradoException(String message) {
		this.mensagem = message;
	}

	public String getMensagem() {
		return mensagem;
	}

}
