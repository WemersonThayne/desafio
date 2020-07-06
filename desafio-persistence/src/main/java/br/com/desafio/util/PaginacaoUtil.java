package br.com.desafio.util;

import br.com.desafio.dto.BaseDTO;
import br.com.desafio.dto.PaginacaoDTO;

/**
 * Classe utilitária para cálculos de paginação
 *
 * @author wemerson.vitalporto
 */
public class PaginacaoUtil {

	private PaginacaoUtil() {
		super();
	}

	/**
	 * Método auxiliar que calcula a página atual que será exibido ao usuário
	 * 
	 * @author wemerson.vitalporto
	 *
	 * @param numeroPagina
	 * @return
	 */
	public static Integer calcularIndiceInicial(PaginacaoDTO<? extends BaseDTO> paginacaoDTO) {
		return paginacaoDTO.getCurrentPage() * paginacaoDTO.getPageSize();
	}

	public static Integer calcularIndiceFinal(PaginacaoDTO<? extends BaseDTO> paginacaoDTO) {
		return paginacaoDTO.getPageSize();
	}
}