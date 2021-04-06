package com.testtask.service.user_service.main_functional;

import com.testtask.dao.model.enums.UserStatusEnum;
import com.testtask.dao.model.user.User;
import com.testtask.dto.user.UserStatusInfo;
import com.testtask.dto.user.IdData;
import com.testtask.exception.user.UserException;
import com.testtask.service.file_service.ImageLoadService;
import com.testtask.service.user_service.database.UserDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserAccountManagementService implements UserManagement{
    private final UserDBService userDBService;
    private final ImageLoadService imageLoadService;

    @Override
    public Integer addNewUser(User user) {
        if (user == null) {
            throw new UserException("Invalid user");
        }

        if (user.getImageURI() == null || user.getImageURI().isEmpty()) {
            throw new UserException("Image URI is empty");
        }

        if (!imageLoadService.isContainsFile(user.getImageURI())) {
            throw new UserException("There is no such image in the catalog");
        }

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new UserException("Name is empty");
        }

        if (!isEmailValid(user.getEmail())) {
            throw new UserException("Invalid email");
        }

        if (isEmailRegistered(user.getEmail())) {
            throw new UserException("A user with this email address is already registered");
        }

        user.setStatusEnum(UserStatusEnum.ONLINE);

        return userDBService.save(user);
    }

    @Override
    public User getUserInfo(IdData idData) {
        if (idData == null) {
            throw new UserException("Invalid id dto");
        }

        Integer id = idData.getId();

        return userDBService.findById(id);
    }

    @Override
    public UserStatusInfo changeUserStatus(UserStatusInfo userStatusInfo) {
        if (userStatusInfo == null) {
            throw new UserException("Invalid user status info");
        }

        Integer userId = userStatusInfo.getId();

        if (userId == null) {
            throw new UserException("Invalid id");
        }

        UserStatusEnum userNewStatusEnum = userStatusInfo.getNewStatus();

        if (userNewStatusEnum == null) {
            throw new UserException("Invalid new status");
        }

        User user = userDBService.findById(userId);

        UserStatusEnum userPrevStatusEnum = user.getStatusEnum();

        if (userPrevStatusEnum.equals(userNewStatusEnum)) {
            throw new UserException("The user already has this status set");
        }

        userStatusInfo.setPrevStatus(userPrevStatusEnum);

        user.setStatusEnum(userNewStatusEnum);

        user.setStatusChangeDate(new Date());

        userDBService.update(user);

        return userStatusInfo;
    }

    private boolean isEmailValid(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private boolean isEmailRegistered(String email) {
        List<User> users = userDBService.getAll();

        return users.stream().anyMatch(u -> u.getEmail().equals(email));
    }
}