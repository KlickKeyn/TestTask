package com.testtask.dao.model;

import com.testtask.dao.model.enums.UserStateEnum;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    @NonNull
    private Integer id;
    @NonNull
    private String imageURI;
    @NonNull
    private String email;
    private UserStateEnum stateEnum;
}
