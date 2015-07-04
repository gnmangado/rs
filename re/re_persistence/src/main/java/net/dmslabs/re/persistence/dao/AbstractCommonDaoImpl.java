package net.dmslabs.re.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.dmslabs.re.domain.common.BaseIntegerIdentificableEntity;
import net.dmslabs.re.persistence.dao.remote.CommonDao;

import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractCommonDaoImpl<T extends BaseIntegerIdentificableEntity> implements CommonDao<T> {

    @PersistenceContext
    private EntityManager em;

    private Class<T> clazz;

    protected AbstractCommonDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Transactional
    public T store(T e) {
        em.persist(e);
        return e;
    }

    @Transactional
    public T update(T e) {
        em.merge(e);
        return e;
    }
    
    @Transactional
    public void remove(Integer id) {
        T entity = em.getReference(clazz, id);
        em.remove(entity);
    }

    @Transactional(readOnly = true)
    public T findById(Integer id) {
        return em.find(clazz, id);
    }

    protected EntityManager getEntityManager() {
        return em;
    }

}
