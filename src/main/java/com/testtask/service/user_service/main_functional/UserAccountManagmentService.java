package com.testtask.service.user_service.main_functional;

import com.testtask.dao.model.user.User;
import com.testtask.dao.model.user.UserStatusInfo;
import com.testtask.service.user_service.database.UserDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountManagmentService implements UserManagement{
    private final UserDBService userDBService;


    @Override
    public Integer addNewUser(User user) {
        return userDBService.save(user);
    }

    @Override
    public User getUserInfo(Integer id) {
        return userDBService.findById(id);
    }

    @Override
    public UserStatusInfo changeUserStatus(UserStatusInfo userStatusInfo) {
        return null;
    }
}
