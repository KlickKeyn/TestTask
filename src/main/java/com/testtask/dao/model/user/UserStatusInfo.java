package com.testtask.dao.model.user;

import com.testtask.dao.model.enums.UserStatusEnum;
import lombok.Data;

@Data
public class UserStatusInfo {
    private Integer id;
    private UserStatusEnum newStatus;
    private UserStatusEnum prevStatus;
}
