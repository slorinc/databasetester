package com.avinode.databasetester.services;

import com.avinode.databasetester.beans.AjaxBean;
import com.avinode.databasetester.dto.QueryResult;
import com.avinode.databasetester.dto.QueryResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * DatabaseQueryService
 *
 * @author <a href="mailto:lorinc.sonnevend@avinode.com">Lorinc Sonnevend</a>
 *         <p>
 *         Created on 23/03/16.
 */
@Service
public class DatabaseQueryService {

    @Autowired
    private AjaxBean ajaxBean;

    @Async
    public Future<QueryResult> executeQuery(JdbcTemplate jdbcTemplate, final int numberOfTimes, final String sqlStatement){

        List<String> list = new LinkedList<>();

        Instant start = Instant.now();
        IntStream.rangeClosed(1, numberOfTimes).forEach(i -> {
                    ajaxBean.setCounter(i);
                    try {
                        jdbcTemplate.execute(sqlStatement);
                    } catch (DataAccessException e) {
                        list.add(e.getLocalizedMessage());
                    }
                }
        );
        long executionTime = Duration.between(start, Instant.now()).toMillis();
        ajaxBean.setCounter(0);
        return new AsyncResult<>(new QueryResultBuilder().setErrorList(list).setExecutionTime(executionTime).createQueryResult());
    }

}
