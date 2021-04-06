package com.testtask.dto.statistics;

import com.testtask.dto.user.UserStatusURIData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StatisticsResponseData {
    private List<UserStatusURIData> userStatusURIDataList;
    private Integer requestId;
}
