package br.com.desafio.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe modelo que representa a unidade de saúde.
 * @author wemerson.vitalporto
 *
 */
@Entity
public class Unidade extends EntidadeBase<Long> {

	private static final long serialVersionUID = -5437896452895216428L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUnidade", nullable = false)
	private Long id;
	
	@Column(name = "nomeUnidade", nullable = false)
	private String nomeUnidade;

	public Unidade() {
		super();
	}

	public Unidade(Long id, String nomeUnidade) {
		super();
		this.id = id;
		this.nomeUnidade = nomeUnidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeUnidade == null) ? 0 : nomeUnidade.hashCode());
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
		Unidade other = (Unidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeUnidade == null) {
			if (other.nomeUnidade != null)
				return false;
		} else if (!nomeUnidade.equals(other.nomeUnidade))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Unidade [id=" + id + ", nomeUnidade=" + nomeUnidade + "]";
	}

}
