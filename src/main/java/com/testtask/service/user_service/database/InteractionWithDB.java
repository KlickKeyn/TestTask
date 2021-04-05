package com.testtask.service.user_service.database;

import com.testtask.dao.model.user.User;

import java.util.List;

public interface InteractionWithDB {
    List<User> getAll();

    User findById(Integer id);

    Integer save(User user);

    User update(User user);

    void delete(Integer id);
}
