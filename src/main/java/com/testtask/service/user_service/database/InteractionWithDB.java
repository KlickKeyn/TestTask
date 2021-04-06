package com.testtask.service.user_service.database;

import java.util.List;

public interface InteractionWithDB<T> {
    List<T> getAll();

    T findById(Integer id);

    Integer save(T entity);

    T update(T entity);

    void delete(Integer id);
}
