package com.testtask.controller.statistics;

import com.testtask.dto.statistics.StatisticalRequestData;
import com.testtask.dto.statistics.StatisticsResponseData;
import com.testtask.service.statistics_service.statistics.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsService statisticsService;

    @GetMapping("/getStatistics")
    public StatisticsResponseData getStatistics(@RequestBody StatisticalRequestData statisticalRequestData) {
        return statisticsService.getStatistics(statisticalRequestData);
    }
}
