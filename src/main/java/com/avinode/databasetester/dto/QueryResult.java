package com.avinode.databasetester.dto;

import java.util.List;

/**
 * QueryResult
 *
 * @author <a href="mailto:lorinc.sonnevend@avinode.com">Lorinc Sonnevend</a>
 *         <p>
 *         Created on 23/03/16.
 */
public class QueryResult {

    private long executionTime;

    private List<String> errorList;

    public QueryResult(long executionTime, List<String> errorList) {
        this.executionTime = executionTime;
        this.errorList = errorList;
    }

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
}
