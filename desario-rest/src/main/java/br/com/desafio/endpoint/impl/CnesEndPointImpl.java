package br.com.desafio.endpoint.impl;

import java.util.List;

import javax.ejb.EJB;

import br.com.desafio.dto.CnesDTO;
import br.com.desafio.dto.PaginacaoDTO;
import br.com.desafio.endpoint.CnesEndPoint;
import br.com.desafio.persistence.model.Cnes;
import br.com.desafio.service.CnesService;

public class CnesEndPointImpl implements CnesEndPoint {

	@EJB
	private CnesService service;
	
	@Override
	public PaginacaoDTO<CnesDTO> listar(PaginacaoDTO<CnesDTO> paginacaoDTO) {
		return service.listar(paginacaoDTO);
	}

}
