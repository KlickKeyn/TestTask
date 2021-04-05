package com.testtask.service.user_service.database;

import com.testtask.dao.model.user.User;
import com.testtask.database.DBstub;
import com.testtask.exception.user.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDBService implements InteractionWithDB {

    private final DBstub dBstub;

    @Override
    public List<User> getAll() {
        return dBstub.findAll();
    }

    @Override
    public User findById(Integer id) {
        throwIfInvalidId(id);

        throwIfNoIdInDb(id);

        return dBstub.findById(id);
    }

    @Override
    public Integer save(User user) {
        throwIfInvalidUser(user);

        User addedUser = dBstub.add(user);

        return addedUser.getId();
    }

    @Override
    public User update(User user) {
        throwIfInvalidUser(user);

        return dBstub.update(user);
    }

    @Override
    public void delete(Integer id) {
        throwIfInvalidId(id);

        throwIfNoIdInDb(id);

        dBstub.delete(id);
    }

    private Integer getMaxUserId() {
        return getAll().size() - 1;
    }

    private void throwIfNoIdInDb(Integer id) {
        Integer maxUserIdInDb = getMaxUserId();

        if (id > maxUserIdInDb) {
            throw new UserException("No user with such id");
        }
    }

    private void throwIfInvalidId(Integer id) {
        if (id == null) {
            throw new UserException("Invalid id");
        }
    }

    private void throwIfInvalidUser(User user) {
        if (user == null) {
            throw new UserException("Invalid user");
        }
    }
}
