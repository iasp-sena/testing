/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.csf.adsi.fichas.test.apptesttienda.dao.jpa;

import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ismael
 */
public abstract class AbstractDAO<T, K> {

    private static final String FORMAT_FIND_ALL = "%s.findAll";

    @PersistenceContext(unitName = "appTiendaPU")
    private EntityManager em;

    private Class<T> type;

    public AbstractDAO(Class<T> type) {
        this.type = type;
    }

    public T buscarPorId(K id) {
        if (Objects.nonNull(id)) {
            return em.find(type, id);
        }
        return null;
    }

    public List<T> buscarTodos() {
        return em.createNamedQuery(String.format(FORMAT_FIND_ALL, type.getSimpleName()), type)
                .getResultList();
    }

}
