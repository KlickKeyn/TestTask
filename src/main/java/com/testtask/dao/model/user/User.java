package com.testtask.dao.model.user;

import com.testtask.dao.model.enums.UserStatusEnum;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String imageURI;
    private String name;
    private String email;
    private UserStatusEnum stateEnum;
}
