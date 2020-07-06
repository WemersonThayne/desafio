package br.com.desafio.persistence.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.desafio.converter.CnesConverter;
import br.com.desafio.dto.CnesDTO;
import br.com.desafio.dto.PaginacaoDTO;
import br.com.desafio.exception.DAOException;
import br.com.desafio.persistence.dao.generic.GenericoDAOImpl;
import br.com.desafio.persistence.model.Cnes;
import br.com.desafio.persistence.model.Cnes_;
import br.com.desafio.persistence.model.Endereco_;
import br.com.desafio.util.PaginacaoUtil;

@LocalBean
@Stateless
public class CnesDAO extends GenericoDAOImpl<Long, Cnes> {
	private static final Logger LOGGER = LoggerFactory.getLogger(CnesDAO.class);

	/**
	 * Método que lista as Unidade CNES com base nos parametros passado na sua
	 * chamada
	 * 
	 * @param paginacaoDTO - parametros de entrada
	 * @return PaginacaoDTO<CnesDTO> - resultado paginado
	 * @throws DAOException
	 */
	public PaginacaoDTO<CnesDTO> listar(PaginacaoDTO<CnesDTO> paginacaoDTO) throws DAOException {
		try {
			CriteriaBuilder builder = super.getEntityManager().getCriteriaBuilder();
			CriteriaQuery<Cnes> query = builder.createQuery(Cnes.class);
			Root<Cnes> root = query.from(Cnes.class);
			List<Predicate> predicados = new ArrayList<>();

			montarQuery(predicados, paginacaoDTO, root, builder);
			if (predicados.size() != 0) {
				query.where(predicados.toArray(new Predicate[predicados.size()])).distinct(true);
			} else {
				query.select(root).distinct(true);
			}

			List<Cnes> resultado = executarQuery(query, paginacaoDTO);

			paginacaoDTO.setList(CnesConverter.convertAll(resultado));
			paginacaoDTO.setTotalResults(totalDeRegistros(query));
			return paginacaoDTO;

		} catch (PersistenceException e) {
			LOGGER.error(DS_EXCEPTION, e);
			throw new DAOException();
		}
	}

	/**
	 * Método responsável por chamar a entityManager
	 * 
	 * @param query
	 * @param paginacaoDTO
	 * @return
	 */
	private List<Cnes> executarQuery(CriteriaQuery<Cnes> query, PaginacaoDTO<CnesDTO> paginacaoDTO) {
		return getEntityManager().createQuery(query).setFirstResult(PaginacaoUtil.calcularIndiceInicial(paginacaoDTO))
				.setMaxResults(PaginacaoUtil.calcularIndiceFinal(paginacaoDTO)).getResultStream()
				.collect(Collectors.toUnmodifiableList());
	}

	/**
	 * Recupera a quantidade de registro com base nos parametros passados
	 * 
	 * @param cq - Query construida
	 * @return Long
	 */
	public Long totalDeRegistros(CriteriaQuery<Cnes> cq) {
		try {
			return getEntityManager().createQuery(cq).getResultStream().count();
		} catch (Exception e) {
			return 0L;
		}
	}

	/**
	 * Monta a query baseada nos parâmetros informados
	 * 
	 * @param predicados   - Lista de predicados para criteiro de busca
	 * @param paginacaoDTO - Parâmetro de entrada
	 * @param root         - Classe root
	 * @param builder      - CriteriaBuilder
	 */
	private void montarQuery(List<Predicate> predicados, PaginacaoDTO<CnesDTO> paginacaoDTO, Root<Cnes> root,
			CriteriaBuilder builder) {
		if (paginacaoDTO.getTipoGestao() != null) {
			predicados.add(builder.equal(root.get(Cnes_.TP_GESTAO), paginacaoDTO.getTipoGestao()));
		}

		if (paginacaoDTO.getEstado() != null) {
			predicados.add(builder.equal(builder.upper(root.get(Cnes_.ENDERECO).get(Endereco_.UF)),
					paginacaoDTO.getEstado().toUpperCase()));
		}
	}
}
