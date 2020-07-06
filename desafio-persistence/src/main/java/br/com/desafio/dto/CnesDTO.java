package br.com.desafio.dto;

import br.com.desafio.enumeration.TipoGestaoEnum;

/**
 * DTO que representa a entidade {@link Cnes}
 * @author wemerson.vitalporto
 *
 */
public class CnesDTO extends BaseDTO {
	
	private static final long serialVersionUID = -1737323163222588641L;
	
	private Long id;
	private Long codIbge;
	private String nome;
	private TipoGestaoEnum tpGestao;
	private EnderecoDTO endereco;
	private String unidade;
	private String telefone;
	
	public CnesDTO() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
