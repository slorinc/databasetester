package com.avinode.databasetester.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;

/**
 * FormDTO
 *
 * @author <a href="mailto:lorinc.sonnevend@avinode.com">Lorinc Sonnevend</a>
 *         <p>
 *         Created on 23/03/16.
 */
public class FormDTO {

    @NotEmpty
    private String sqlStatement;

    @Digits(integer = 5, fraction = 0)
    private int numberOfTimes;

    @NotEmpty
    private String datasourceUrl;

    @NotEmpty
    private String datasourceUsername;

    @NotEmpty
    private String datasourcePassword;

    public FormDTO() {
    }

    /**
     * @param datasourceUrl
     * @param datasourceUsername
     * @param datasourcePassword
     */
    public FormDTO(int numberOfTimes, String datasourceUrl, String datasourceUsername, String datasourcePassword) {
        this.numberOfTimes = numberOfTimes;
        this.datasourceUrl = datasourceUrl;
        this.datasourceUsername = datasourceUsername;
        this.datasourcePassword = datasourcePassword;
    }

    public String getSqlStatement() {
        return sqlStatement;
    }

    public void setSqlStatement(String sqlStatement) {
        this.sqlStatement = sqlStatement;
    }

    public int getNumberOfTimes() {
        return numberOfTimes;
    }

    public void setNumberOfTimes(int numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    public void setDatasourceUrl(String datasourceUrl) {
        this.datasourceUrl = datasourceUrl;
    }

    public String getDatasourceUsername() {
        return datasourceUsername;
    }

    public void setDatasourceUsername(String datasourceUsername) {
        this.datasourceUsername = datasourceUsername;
    }

    public String getDatasourcePassword() {
        return datasourcePassword;
    }

    public void setDatasourcePassword(String datasourcePassword) {
        this.datasourcePassword = datasourcePassword;
    }
}
