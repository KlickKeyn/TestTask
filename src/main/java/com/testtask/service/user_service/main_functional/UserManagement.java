package com.testtask.service.user_service.main_functional;

import com.testtask.dao.model.user.User;
import com.testtask.dto.user.UserStatusInfo;
import com.testtask.dto.user.IdData;

public interface UserManagement {
    Integer addNewUser(User user);

    User getUserInfo(IdData idData);

    UserStatusInfo changeUserStatus(UserStatusInfo userStatusInfo);
}
