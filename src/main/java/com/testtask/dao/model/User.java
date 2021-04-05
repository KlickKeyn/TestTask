package com.testtask.dao.model;

import com.testtask.dao.model.enums.UserStateEnum;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String imageURI;
    private String email;
    private UserStateEnum stateEnum;
}
