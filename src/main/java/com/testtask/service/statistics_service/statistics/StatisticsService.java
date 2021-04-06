package com.testtask.service.statistics_service.statistics;

import com.testtask.dao.model.enums.UserStatusEnum;
import com.testtask.dao.model.statistics.StatisticsRequest;
import com.testtask.dao.model.user.User;
import com.testtask.dto.statistics.StatisticalRequestData;
import com.testtask.dto.statistics.StatisticsResponseData;
import com.testtask.dto.user.UserStatusURIData;
import com.testtask.exception.statistics.StatisticsException;
import com.testtask.service.statistics_service.database.StatisticsRequestDBService;
import com.testtask.service.user_service.database.UserDBService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsService {
    private final StatisticsRequestDBService statisticsRequestDBService;
    private final UserDBService userDBService;

    public StatisticsResponseData getStatistics(StatisticalRequestData statisticalRequestData) {
        if (statisticalRequestData == null) {
            throw new StatisticsException("Invalid statistical request data");
        }

        UserStatusEnum filterClientStatus = statisticalRequestData.getClientStatus();
        Integer filterRequestId = statisticalRequestData.getRequestId();

        List<User> users = userDBService.getAll();
        if (users.isEmpty()) {
            throw new StatisticsException("There are no users in database for create statistics");
        }

        List<User> filteredRequestIdUsers = filterByRequestId(filterRequestId, users);

        List<User> statusSortedUserList = filterByUserStatus(filterClientStatus, filteredRequestIdUsers);

        return new StatisticsResponseData
                (
                        getUserStatusURIDataList(statusSortedUserList),
                        filterRequestId
                );
    }

    private List<User> filterByUserStatus(UserStatusEnum filterClientStatus, List<User> filteredRequestIdUsers) {
        List<User> statusSortedUserList;
        if (filterClientStatus != null) {
            statusSortedUserList = filteredRequestIdUsers.stream().filter(u -> u.getStatusEnum().equals(filterClientStatus)).collect(Collectors.toList());
        } else {
            statusSortedUserList = filteredRequestIdUsers;
        }
        return statusSortedUserList;
    }

    private List<User> filterByRequestId(Integer filterRequestId, List<User> users) {
        List<User> filteredRequestIdUsers = new ArrayList<>();

        if (filterRequestId != null) {
            if (statisticsRequestDBService.isHasRequest(filterRequestId)) {
                Date requestDate = statisticsRequestDBService.findById(filterRequestId).getRequestDate();

                users.forEach(u -> {
                    if (u.getStatusChangeDate() != null && requestDate.before(u.getStatusChangeDate())) {
                        filteredRequestIdUsers.add(u);
                    }
                });
            } else {
                statisticsRequestDBService.save(new StatisticsRequest(filterRequestId, new Date()));
            }
        } else {
            filteredRequestIdUsers.addAll(users);
        }

        return filteredRequestIdUsers;
    }

    private List<UserStatusURIData> getUserStatusURIDataList(List<User> users) {
        List<UserStatusURIData> usersShortData = new ArrayList<>();
        users.forEach(u -> usersShortData.add(new UserStatusURIData(u.getStatusEnum(), u.getImageURI())));

        return usersShortData;
    }
}
