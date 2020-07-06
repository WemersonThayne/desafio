package br.com.desafio;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.desafio.dto.CnesDTO;
import br.com.desafio.dto.PaginacaoDTO;
import br.com.desafio.exception.DAOException;
import br.com.desafio.exception.NegocioException;
import br.com.desafio.persistence.dao.CnesDAO;
import br.com.desafio.service.CnesService;

/**
 * Classe de testes unitário da classe {@link CnesService}
 * @author wemerson.vitalporto
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CnesServiceTest 
{
	@Mock
	private CnesDAO dao;
	
	@InjectMocks
	private CnesService service;
	
	private PaginacaoDTO<CnesDTO> paginacaoDTO;
	
	@Before
	public void init() {
		paginacaoDTO =  new PaginacaoDTO<CnesDTO>();
		paginacaoDTO.setList(new ArrayList<CnesDTO>());
		paginacaoDTO.setTotalResults(0L);
	}

	@Test
	public void testListarTodos() throws DAOException {
		when(dao.listar(paginacaoDTO)).thenReturn(paginacaoDTO);
		PaginacaoDTO<CnesDTO> retorno = this.service.listar(paginacaoDTO);
		assertEquals(0L, retorno.getTotalResults().longValue());
	}

	@Test(expected = NegocioException.class)
	public void testListarTodosComProblemaDAO() throws DAOException {
		doThrow(DAOException.class).when(dao).listar(paginacaoDTO);
		service.listar(paginacaoDTO);
	}
}
