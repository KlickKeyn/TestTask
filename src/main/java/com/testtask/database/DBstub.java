package com.testtask.database;


import com.testtask.dao.model.user.User;
import com.testtask.dao.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBstub implements UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> findAll() {
        return users;
    }

    public User findById(Integer id) {
        return users.get(id);
    }

    public User add(User user) {
        users.add(user);
        Integer newId = users.indexOf(user);
        user.setId(newId);

        return user;
    }

    public User update(User user) {
        users.set(user.getId(), user);

        return user;
    }

    public void delete(Integer id) {
        users.remove(id);
    }
}
