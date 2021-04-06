package com.testtask.dto.statistics;

import com.testtask.dao.model.enums.UserStatusEnum;
import lombok.Data;

@Data
public class StatisticalRequestData {
    private UserStatusEnum clientStatus;
    private Integer requestId;
}
