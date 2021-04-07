package com.testtask.service.user_service.database;

import com.testtask.BaseTest;
import com.testtask.dao.model.user.User;
import com.testtask.database.user.UserDBStub;
import com.testtask.exception.user.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

class UserDBServiceTest extends BaseTest {

    @Autowired
    private UserDBService userDBService;

    @Mock
    private UserDBStub userDBStub;

    @Test
    void save_valid_user() {
        User user = new User();
        User resultUser = new User();
        resultUser.setId(0);

        Mockito.when(userDBStub.add(user)).thenReturn(resultUser);

        Integer userId = userDBService.save(user);
        Assertions.assertEquals(0, userId);
    }

    @Test
    void save_invalid_user() {
        Assertions.assertThrows(UserException.class, () -> userDBService.save(null));
    }
}