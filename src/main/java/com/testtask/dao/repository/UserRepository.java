package com.testtask.dao.repository;

import com.testtask.dao.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findById(Integer id);

    User add(User user);

    User update(User user);

    void delete(Integer id);
}
