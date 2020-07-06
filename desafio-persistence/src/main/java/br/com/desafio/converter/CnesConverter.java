package br.com.desafio.converter;

import java.util.List;
import java.util.stream.Collectors;

import br.com.desafio.dto.CnesDTO;
import br.com.desafio.dto.EnderecoDTO;
import br.com.desafio.persistence.model.Cnes;

public class CnesConverter {

	private CnesConverter() {}
	
	public static CnesDTO convertToDTO(Cnes cnes) {
		CnesDTO dto = new CnesDTO();
		dto.setId(cnes.getId());
		dto.setCodIbge(cnes.getCodIbge());
		dto.setNome(cnes.getNome());
		dto.setTelefone(cnes.getTelefone() == null ? "" : cnes.getTelefone());
		dto.setTpGestao(cnes.getTpGestao());
		dto.setUnidade(cnes.getUnidade() == null ? "" : cnes.getUnidade().getNomeUnidade());
		dto.setEndereco(new EnderecoDTO(cnes.getEndereco()));
		return dto;
	}
	
	public static List<CnesDTO> convertAll(List<Cnes> cnesList) {
		return cnesList.stream().map(CnesConverter::convertToDTO).collect(Collectors.toList());
	}
}
