package com.testtask.dao.model.statistics;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class StatisticsRequest {
    private Integer id;
    private Date requestDate;
}
