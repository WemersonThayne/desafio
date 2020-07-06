package br.com.desafio.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.desafio.dto.CnesDTO;
import br.com.desafio.dto.PaginacaoDTO;
import br.com.desafio.exception.DAOException;
import br.com.desafio.exception.NegocioException;
import br.com.desafio.persistence.dao.CnesDAO;
import br.com.desafio.persistence.model.Cnes;
import br.com.desafio.service.generic.GenericServiceImpl;

@LocalBean
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class CnesService extends GenericServiceImpl<Long, Cnes> {

	private static final long serialVersionUID = -7636571693783435597L;

	@EJB
	private CnesDAO dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Cnes gravar(Cnes cnes) {
		return super.gravar(cnes);
	}
	
	public PaginacaoDTO<CnesDTO> listar(PaginacaoDTO<CnesDTO> paginacaoDTO){
		try {
			return dao.listar(paginacaoDTO);
		} catch (DAOException e) {
			throw new NegocioException(e.getMessage());
		}	
	}
}
