package com.testtask.service.statistics_service.database;

import com.testtask.dao.model.statistics.StatisticsRequest;
import com.testtask.database.statistics.StatisticsDBStub;
import com.testtask.exception.statistics.StatisticsException;
import com.testtask.service.user_service.database.InteractionWithDB;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsRequestDBService implements InteractionWithDB<StatisticsRequest> {
    private final StatisticsDBStub statisticsDBStub;

    @Override
    public List<StatisticsRequest> getAll() {
        return statisticsDBStub.findAll();
    }

    @Override
    public StatisticsRequest findById(Integer id) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new StatisticsException("Interrupt exception", ex);
        }

        throwIfInvalidId(id);

        throwIfNoIdInDb(id);

        return statisticsDBStub.findById(id);
    }

    @Override
    public Integer save(StatisticsRequest request) {
        throwIfInvalidUser(request);

        StatisticsRequest addedRequest = statisticsDBStub.add(request);

        return addedRequest.getId();
    }

    @Override
    public StatisticsRequest update(StatisticsRequest request) {
        throwIfInvalidUser(request);

        return statisticsDBStub.update(request);
    }

    @Override
    public void delete(Integer id) {
        throwIfInvalidId(id);

        throwIfNoIdInDb(id);

        statisticsDBStub.delete(id);
    }

    public boolean isHasRequest(Integer id) {
        return statisticsDBStub.findById(id) != null;
    }

    private void throwIfNoIdInDb(Integer id) {
        if (!isHasRequest(id)) {
            throw new StatisticsException("No request with such id");
        }
    }

    private void throwIfInvalidId(Integer id) {
        if (id == null) {
            throw new StatisticsException("Invalid id");
        }
    }

    private void throwIfInvalidUser(StatisticsRequest request) {
        if (request == null) {
            throw new StatisticsException("Invalid request");
        }
    }
}
