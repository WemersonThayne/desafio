package br.com.desafio.service.generic;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.desafio.enumeration.MensagemEnum;
import br.com.desafio.exception.DAOException;
import br.com.desafio.exception.NegocioException;
import br.com.desafio.exception.RegistroNaoEncontradoException;
import br.com.desafio.persistence.dao.generic.GenericoDAO;
import br.com.desafio.persistence.model.EntidadeBase;
import br.com.desafio.util.MensagemUtil;

@Stateless
public class GenericServiceImpl<K extends Serializable, T extends EntidadeBase<K>> implements GenericService<K, T> {

	private static final long serialVersionUID = -5466787669491882642L;

	@EJB
	private GenericoDAO<K, T> dao;

	@Override
	public List<T> listar() {
		List<T> retorno = null;
		try {
			retorno = this.dao.listar();
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
		return retorno;
	}

	@Override
	public T consultarPorId(K id) {
		T retorno = null;
		try {
			retorno = this.dao.consultarPorId(id);
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
		return retorno;
	}

	@Override
	public T gravar(T objeto) {
		T retorno = null;
		try {
			retorno = this.dao.gravar(objeto);
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
		return retorno;
	}

	@Override
	public void excluir(K id) throws RegistroNaoEncontradoException {
		try {
			T entidade = dao.consultarPorId(id);
			if (entidade == null) {
				throw new RegistroNaoEncontradoException();
			}
			dao.excluir(entidade);
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
	}

	@Override
	public void excluir(T objeto) {
		try {
			this.dao.excluir(objeto);
		} catch (DAOException e) {
			throw new NegocioException(MensagemUtil.getMessage(MensagemEnum.MSG001));
		}
	}

}
