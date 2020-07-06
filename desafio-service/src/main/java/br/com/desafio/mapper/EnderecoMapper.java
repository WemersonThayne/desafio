package br.com.desafio.mapper;

import br.com.desafio.persistence.model.Endereco;

public class EnderecoMapper {
	private EnderecoMapper() {
		super();
	}
	
	public static Endereco mapperToLinha(String[] colunas){
		Endereco endereco = new Endereco();
		endereco.setLogradouro(colunas.length <= 5 ? null : colunas[5]);
		endereco.setNumero(colunas.length <= 6 ? null : colunas[6]);
		endereco.setBairro(colunas.length <= 7 ? null : colunas[7]);
		endereco.setCep(colunas.length <= 8 ? null : colunas[8]);
		endereco.setUf(colunas.length <= 9 ? null : colunas[9]);
		endereco.setMunicipio(colunas.length <= 10 ? null : colunas[10]);
		return endereco;
	}
}
