package com.lxiang.base.core.dao;

import java.io.Serializable;
import java.util.List;

/**
 * GenericDAO
 *
 * @author Administrator
 * @since 2015/4/12
 */
public interface GenericDAO<T, ID extends Serializable> {

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    T findById(ID id);

    List<T> findAll();

    void flush();

}
