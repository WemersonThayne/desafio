package br.com.desafio.dto;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.Positive;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import br.com.desafio.enumeration.TipoGestaoEnum;

/**
 * Objeto para paginação de registros
 *
 * @author wemerson.vitalporto
 */
public class PaginacaoDTO<T extends BaseDTO> implements Serializable {
	private static final long serialVersionUID = 2893650096294484485L;

	@DefaultValue("0")
	@QueryParam("currentPage")
	private Integer currentPage;

	@Positive
	@DefaultValue("5")
	@QueryParam("pageSize")
	private Integer pageSize;
	
	@QueryParam("tipoGestao")
	private TipoGestaoEnum tipoGestao;

	@QueryParam("estado")
	private String estado;

	private Long totalResults;
	private String sortingFields;
	private String sortingDirections;
	private transient Map<String, Object> filter;
	private List<T> list;

	public PaginacaoDTO() {
		super();
	}

	public PaginacaoDTO(Integer currentPage, Integer pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(Long totalResults) {
		this.totalResults = totalResults;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getSortingFields() {
		return sortingFields;
	}

	public void setSortingFields(String sortingFields) {
		this.sortingFields = sortingFields;
	}

	public String getSortingDirections() {
		return sortingDirections;
	}

	public void setSortingDirections(String sortingDirections) {
		this.sortingDirections = sortingDirections;
	}

	public Map<String, Object> getFilter() {
		return filter;
	}

	public void setFilter(Map<String, Object> filter) {
		this.filter = filter;
	}

	public TipoGestaoEnum getTipoGestao() {
		return tipoGestao;
	}

	public void setTipoGestao(TipoGestaoEnum tipoGestaoEnum) {
		this.tipoGestao = tipoGestaoEnum;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}