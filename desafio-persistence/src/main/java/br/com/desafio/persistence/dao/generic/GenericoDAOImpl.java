package br.com.desafio.persistence.dao.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.desafio.exception.DAOException;
import br.com.desafio.persistence.ValidatorBase;
import br.com.desafio.persistence.model.EntidadeBase;

/**
 * Fornece as funções básicas de um DAO
 *
 * @param <K> - Chave
 * @param <T> - Tipo
 */
@Stateless
public class GenericoDAOImpl<K extends Serializable, T extends EntidadeBase<K>> implements GenericoDAO<K, T> {

	public static final String PERSISTENCE_UNIT = "br.com.desafio";
	protected static final String AND = " AND ";
	protected static final String OR = " OR ";
	public static final String DS_EXCEPTION = "Ocorreu um erro durante a execução: ";
	private static final Logger LOG = LoggerFactory.getLogger(GenericoDAOImpl.class);

	@PersistenceContext(unitName = PERSISTENCE_UNIT)
	private EntityManager em;

	/**
	 * Método generico para consulta sem criterio 
	 */
	@Override
	public List<T> listar() throws DAOException {
		List<T> retorno = null;
		try {
			retorno = getEntityManager().createQuery(getCriteriaBuilder().createQuery(getTypeClass())).getResultList();
		} catch (PersistenceException e) {
			LOG.error(DS_EXCEPTION, e);
			throw new DAOException();
		}

		return retorno;
	}

	/**
	 * consulta um objeto pelo seu id
	 */
	@Override
	public T consultarPorId(K id) throws DAOException {
		T retorno = null;
		try {
			retorno = getEntityManager().find(getTypeClass(), id);
		} catch (PersistenceException e) {
			LOG.error(DS_EXCEPTION, e);
			throw new DAOException();
		}

		return retorno;
	}

	/**
	 * Grava ou atualiza um objeto na base de dados
	 */
	@Override
	public T gravar(T objeto) throws DAOException {
		ValidatorBase.validate(objeto);
		try {
			if (objeto.getId() == null) {
				getEntityManager().persist(objeto);
			} else {
				getEntityManager().merge(objeto);
			}
		} catch (PersistenceException e) {
			LOG.error(DS_EXCEPTION, e);
			throw new DAOException();
		}

		return objeto;
	}

	/**
	 * Remove um objeto da base pasando ele por referencia
	 */
	@Override
	public void excluir(T objeto) throws DAOException {
		ValidatorBase.validate(objeto);
		try {
			getEntityManager().remove(objeto);
		} catch (PersistenceException e) {
			LOG.error(DS_EXCEPTION, e);
			throw new DAOException();
		}
	}

	/**
	 * Remove o objeto baseado no id passadoO
	 */
	@Override
	public void excluir(K id) throws DAOException {
		try {
			T objeto = consultarPorId(id);
			excluir(objeto);
		} catch (DAOException e) {
			LOG.error(DS_EXCEPTION, e);
			throw new DAOException();
		}
	}

	@SuppressWarnings("unchecked")
	private Class<T> getTypeClass() {
		return (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	protected CriteriaBuilder getCriteriaBuilder() {
		return getEntityManager().getCriteriaBuilder();
	}

	public EntityManager getEntityManager() {
		return em;
	}
}