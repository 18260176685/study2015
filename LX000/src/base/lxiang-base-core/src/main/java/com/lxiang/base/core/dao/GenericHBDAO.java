package com.lxiang.base.core.dao;

/**
 * GenericHBDAO
 *
 * @author Administrator
 * @since 2015/4/12
 */

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class GenericHBDAO<T,ID extends Serializable> implements GenericDAO<T,ID> {

    private Class<T> persistentClass;

    @Autowired
    private SessionFactory sessionFactory;

    public GenericHBDAO(Class<T> persistentClass){
        this.persistentClass = persistentClass;
    }

    public Class<T> getPersistentClass(){
        return this.persistentClass;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return this.sessionFactory.openSession();
    }

    public T findById(ID id){
        T entity = (T)getSession().get(getPersistentClass(),id);
        return entity;
    }

    public T save(T entity){
        getSession().save(entity);
        return entity;
    }

    public T update(T entity){
        getSession().merge(entity);
        return entity;
    }

    public void delete(T entity){
        getSession().delete(entity);
    }

    public List<T> findAll(){
        return getSession().createQuery(
                "select x from " + getPersistentClass().getSimpleName() + " x").list();
    }

    /**
     * Flush changes for current entity manager.
     */
    public void flush(){
        getSession().flush();
    }

}
