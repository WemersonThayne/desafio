package br.com.desafio.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.desafio.enumeration.TipoGestaoEnum;

@Entity
public class Cnes extends EntidadeBase<Long> {

	private static final long serialVersionUID = 3677205138752953575L;

	@Id
	@Column(name = "idCnes", nullable = false)
	private Long id;

	@Column(name = "codIbge", nullable = false)
	private Long codIbge;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "tpGestao", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoGestaoEnum tpGestao;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idEndereco")
	private Endereco endereco;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "idUnidade")
	private Unidade unidade;
	
	@Column(name = "telefone")	
	private String telefone;

	public Cnes() {
		super();
	}

	public Cnes(Long id, Long codIbge, String nome, TipoGestaoEnum tpGestao, Endereco endereco, Unidade unidade,
			String telefone) {
		super();
		this.id = id;
		this.codIbge = codIbge;
		this.nome = nome;
		this.tpGestao = tpGestao;
		this.endereco = endereco;
		this.unidade = unidade;
		this.telefone = telefone;
	}

	public Cnes(Long id, Long codIbge, String nome, String nomeUnidade, String tpGestao, String logradouro,
			String numero, String bairro, String cep, String uf, String municipio, String telefone) {
		this.id = id;
		this.nome = nome;
		this.tpGestao = TipoGestaoEnum.valueOf(tpGestao);
		this.endereco = new Endereco(null, cep, uf, municipio, bairro, numero, logradouro);
		this.unidade = new Unidade(null, nomeUnidade);
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idCnes) {
		this.id = idCnes;
	}

	public Long getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(Long codIbge) {
		this.codIbge = codIbge;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoGestaoEnum getTpGestao() {
		return tpGestao;
	}

	public void setTpGestao(TipoGestaoEnum tpGestao) {
		this.tpGestao = tpGestao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		Cnes other = (Cnes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cnes [id=" + id + ", codIbge=" + codIbge + ", nome=" + nome + ", tpGestao=" + tpGestao + ", endereco="
				+ endereco + ", unidade=" + unidade + ", telefone=" + telefone + "]";
	}

}
