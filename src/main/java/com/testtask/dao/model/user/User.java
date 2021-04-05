package com.testtask.dao.model.user;

import com.testtask.dao.model.enums.UserStatusEnum;
import lombok.Data;
import javax.validation.constraints.Email;

@Data
public class User {
    private Integer id;
    private String imageURI;
    private String name;
    @Email
    private String email;
    private UserStatusEnum stateEnum;
}
