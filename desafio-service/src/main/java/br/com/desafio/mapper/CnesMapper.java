package br.com.desafio.mapper;

import br.com.desafio.enumeration.TipoGestaoEnum;
import br.com.desafio.persistence.model.Cnes;

public class CnesMapper {

	private CnesMapper() {
		super();
	}
	
	public static Cnes mapperToLinha(String[] colunas){
		Cnes cnes = new Cnes();
		cnes.setId(Long.parseLong(colunas.length <= 0 ? null : colunas[0] ));
		cnes.setCodIbge(Long.parseLong(colunas.length <= 1 ? null : colunas[1] ));
		cnes.setNome(colunas.length <= 2 ? null : colunas[2] );
		cnes.setUnidade(UnidadeMapper.mapperToLinha(colunas.length <= 3 ? null : colunas[3] ));
		cnes.setTpGestao(TipoGestaoEnum.valueOf(colunas.length <= 4 ? null : colunas[4] ));
		cnes.setEndereco(EnderecoMapper.mapperToLinha(colunas));//colunas[5,6,7,8,9,10]
		cnes.setTelefone(colunas.length <= 11 ? null :  colunas[11] );
		return cnes;
	}
	
}
