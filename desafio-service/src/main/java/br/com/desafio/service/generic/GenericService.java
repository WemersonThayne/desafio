package br.com.desafio.service.generic;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import br.com.desafio.exception.RegistroNaoEncontradoException;
import br.com.desafio.persistence.model.EntidadeBase;

@Local
public interface GenericService<K extends Serializable, T extends EntidadeBase<K>> extends Serializable {

	/**
	 * Lista todas as entidades existentes
	 * 
	 * @return lista de entidades existentes
	 */
	List<T> listar();

	/**
	 * Recupera a entidade de acordo com o tipo e com o id.
	 * 
	 * @param tipo tipo da entidade
	 * @param id   identificador
	 * @return entidade encontrada, <code>null</code> caso não seja encontrada
	 */
	T consultarPorId(K id);

	/**
	 * Realiza a persistência de uma entidade, caso ela tenha um id será chamado o
	 * método {@link javax.persistence.EntityManager#persist(Object)} caso exista
	 * será chamado o método {@link javax.persistence.EntityManager#merge(Object)}
	 * do {@link javax.persistence.EntityManager}
	 * 
	 * @param objeto objeto que será persistido
	 * @return retorna o objeto persistido, caso seja um novo objeto ele terá o id
	 *         configurado
	 */
	T gravar(T objeto);

	/**
	 * Exclui uma entidade de acordo com o tipo e o id.
	 *
	 * @param tipo tipo da entidae
	 * @param id   identificador
	 * @throws RegistroNaoEncontradoException
	 */
	void excluir(K id) throws RegistroNaoEncontradoException;

	/**
	 * Exclui uma entidade.
	 * 
	 * @param objeto entidade que será excluída
	 */
	void excluir(T objeto);

}
