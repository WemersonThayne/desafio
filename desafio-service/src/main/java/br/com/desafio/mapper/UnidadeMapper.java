package br.com.desafio.mapper;

import br.com.desafio.persistence.model.Unidade;

public class UnidadeMapper {
	private UnidadeMapper() {
		super();
	}
	
	public static Unidade mapperToLinha(String coluna){
		Unidade unidade = new Unidade();
		unidade.setNomeUnidade(coluna);
		return unidade;
	}
}
