package br.com.desafio.persistence.dao.generic;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import br.com.desafio.exception.DAOException;
import br.com.desafio.persistence.model.EntidadeBase;

/**
 * @author wemerson.vitalporto
 */
@Local
public interface GenericoDAO<K extends Serializable, T extends EntidadeBase<K>> {

    List<T> listar() throws DAOException;

    /**
     * Recupera a entidade de acordo com o tipo e com o id.
     *
     * @param tipo tipo da entidade
     * @param id identificador
     * @return entidade encontrada, <code>null</code> caso não seja encontrada
     * @throws DAOException
     */
    T consultarPorId(K id) throws DAOException;

    /**
     * Realiza a persistência de uma entidade, caso ela tenha um id será chamado o método
     * {@link javax.persistence.EntityManager#persist(Object)} caso exista será chamado o método
     * {@link javax.persistence.EntityManager#merge(Object)} do {@link javax.persistence.EntityManager}
     *
     * @param objeto objeto que será persistido
     * @return retorna o objeto persistido, caso seja um novo objeto ele terá o id configurado
     * @throws DAOException
     */
    T gravar(T objeto) throws DAOException;

    /**
     * Exclui uma entidade.
     *
     * @param objeto entidade que será excluída
     * @throws DAOException
     */
    void excluir(T objeto) throws DAOException;

    /**
     * Exclui uma entidade de acordo com o tipo e o id.
     * 
     * @param tipo tipo da entidae
     * @param id identificador
     */
    void excluir(K id) throws DAOException;
}

