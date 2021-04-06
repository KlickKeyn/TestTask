package com.testtask.dao.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();

    T findById(Integer id);

    T add(T entity);

    T update(T entity);

    void delete(Integer id);
}
