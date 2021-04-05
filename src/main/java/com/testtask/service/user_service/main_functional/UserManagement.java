package com.testtask.service.user_service.main_functional;

import com.testtask.dao.model.user.User;
import com.testtask.dao.model.user.UserStatusInfo;

public interface UserManagement {
    Integer addNewUser(User user);

    User getUserInfo(Integer id);

    UserStatusInfo changeUserStatus(UserStatusInfo userStatusInfo);
}
