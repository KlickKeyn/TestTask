package com.testtask.controller.user;

import com.testtask.BaseTest;
import com.testtask.dao.model.user.User;
import com.testtask.exception.user.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class UserControllerTest extends BaseTest {

    @Autowired
    UserController userController;

    @Test
    void create_valid_user() {
        User user = new User();

        user.setImageURI("945dfb8f-f703-418b-bc31-a9c74f35cdfa.fox.jpg");
        user.setName("Den");
        user.setEmail("Qwrre@mail.ru");

        Integer clientId = userController.createUser(user);

        Assertions.assertEquals(0, clientId);
    }

    @Test
    void create_invalid_user() {
        User user = new User();

        user.setImageURI("945dfb8f-f703-418b-bc31-a9c74f35cdfa.fox.jpg");

        user.setEmail("Qwrre@mail.ru");

        Assertions.assertThrows(UserException.class, () -> userController.createUser(user));
    }
}