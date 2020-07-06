package br.com.desafio.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe modelo para representando o endereço da unidade de saúde
 * 
 * @author wemerson.vitalporto
 *
 */
@Entity
public class Endereco extends EntidadeBase<Long> {

	private static final long serialVersionUID = 249315954794769629L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEndereco", nullable = false)
	private Long id;

	@Column(name = "cep", nullable = false)
	private String cep;

	@Column(name = "uf", nullable = false)
	private String uf;

	@Column(name = "municipio", nullable = false)
	private String municipio;

	@Column(name = "bairro", nullable = false)
	private String bairro;

	@Column(name = "codIbge", nullable = false)
	private String numero;

	@Column(name = "logradouro", nullable = false)
	private String logradouro;

	public Endereco() {
		super();
	}

	public Endereco(Long id, String cep, String uf, String municipio, String bairro, String numero, String logradouro) {
		super();
		this.id = id;
		this.cep = cep;
		this.uf = uf;
		this.municipio = municipio;
		this.bairro = bairro;
		this.numero = numero;
		this.logradouro = logradouro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", uf=" + uf + ", municipio=" + municipio + ", bairro=" + bairro
				+ ", numero=" + numero + ", logradouro=" + logradouro + "]";
	}

}
