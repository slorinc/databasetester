package com.avinode.databasetester.dto;

import java.util.List;

public class QueryResultBuilder {

    private long executionTime;
    private List<String> errorList;

    public QueryResultBuilder setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
        return this;
    }

    public QueryResultBuilder setErrorList(List<String> errorList) {
        this.errorList = errorList;
        return this;
    }

    public QueryResult createQueryResult() {
        return new QueryResult(executionTime, errorList);
    }
}