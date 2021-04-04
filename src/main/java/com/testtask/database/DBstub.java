package com.testtask.database;


import com.testtask.dao.model.User;

import java.util.List;

public class DBstub {
    private List<User> users;

    public List<User> findAll() {
        return users;
    }

    public User findById(Integer id) {
        return users.get(id);
    }

    public Integer add(User user) {
        users.add(user);
        Integer newId = users.indexOf(user);
        user.setId(newId);

        return newId;
    }

    public User update(User user) {
        users.set(user.getId(), user);

        return user;
    }

    public void delete(Integer id) {
        users.remove(id);
    }
}
