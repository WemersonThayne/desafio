package br.com.desafio.exception;

/**
 * Exceção padrão que será propagada para a camada de serviços
 * 
 * @author wemerson.vital
 *
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 1364541629450654254L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}
}
