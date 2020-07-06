package br.com.desafio.util;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.desafio.enumeration.MensagemEnum;

/**
 * Classe utilitário para manipular as mensagens
 * @author wemerson.vitalporto
 *
 */
public final class MensagemUtil {

	// definição estatica para a linguagem pt-br
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages", new Locale("pt", "BR"));

    private MensagemUtil() {
	super();
    }

    public static String getMessage(MensagemEnum mensagemEnum) {
	return new String(RESOURCE_BUNDLE.getString(mensagemEnum.toString()).getBytes());

    }

    public static String getMessage(MensagemEnum mensagemEnum, Object... args) {
	String mensagem = getMessage(mensagemEnum);
	if (args.length > 0) {
	    mensagem = MessageFormat.format(mensagem, args);
	}
	return mensagem;
    }
}
