package com.testtask.database.statistics;

import com.testtask.dao.model.statistics.StatisticsRequest;
import com.testtask.dao.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StatisticsDBStub implements Repository<StatisticsRequest> {
    private List<StatisticsRequest> requests = new ArrayList<>();

    @Override
    public List<StatisticsRequest> findAll() {
        return requests;
    }

    @Override
    public StatisticsRequest findById(Integer id) {
        if (!requests.isEmpty()) {
            return requests.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
        }

        return null;
    }

    @Override
    public StatisticsRequest add(StatisticsRequest request) {
        requests.add(request);

        return request;
    }

    @Override
    public StatisticsRequest update(StatisticsRequest request) {
        StatisticsRequest requestFromDb = findById(request.getId());

        Integer requestId = requests.indexOf(requestFromDb);

        requests.set(requestId, request);

        return request;
    }

    @Override
    public void delete(Integer id) {
        StatisticsRequest request = findById(id);

        requests.remove(request);
    }
}
