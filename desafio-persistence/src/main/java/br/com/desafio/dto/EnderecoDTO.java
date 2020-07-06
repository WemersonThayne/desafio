package br.com.desafio.dto;

import br.com.desafio.persistence.model.Endereco;

/**
 * DTO que representa a entidade {@link Endereco}
 * 
 * @author wemerson.vitalporto
 */
public class EnderecoDTO extends BaseDTO {

	private static final long serialVersionUID = 6992390458446522647L;

	private String cep;
	private String uf;
	private String municipio;
	private String bairro;
	private String numero;
	private String logradouro;

	public EnderecoDTO() {
		super();
	}

	public EnderecoDTO(Endereco endereco) {
		this.cep = endereco.getCep() != null ? endereco.getCep() : "";
		this.bairro = endereco.getBairro() != null ? endereco.getBairro() : "";
		this.logradouro = endereco.getLogradouro() != null ? endereco.getLogradouro() : "";
		this.municipio = endereco.getMunicipio() != null ? endereco.getMunicipio() : "";
		this.numero = endereco.getNumero() != null ? endereco.getNumero() : "";
		this.uf = endereco.getUf() != null ? endereco.getUf() : "";
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

}
