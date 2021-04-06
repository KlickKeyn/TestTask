package com.testtask.dto.user;

import com.testtask.dao.model.enums.UserStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserStatusURIData {
    private UserStatusEnum statusEnum;
    private String imageURI;
}
