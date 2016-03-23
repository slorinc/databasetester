package com.avinode.databasetester.dto;

public class FormDTOBuilder {

    private int numberOfTimes;
    private String datasourceUrl;
    private String datasourceUsername;
    private String datasourcePassword;

    public FormDTOBuilder setNumberOfTimes(int numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
        return this;
    }

    public FormDTOBuilder setDatasourceUrl(String datasourceUrl) {
        this.datasourceUrl = datasourceUrl;
        return this;
    }

    public FormDTOBuilder setDatasourceUsername(String datasourceUsername) {
        this.datasourceUsername = datasourceUsername;
        return this;
    }

    public FormDTOBuilder setDatasourcePassword(String datasourcePassword) {
        this.datasourcePassword = datasourcePassword;
        return this;
    }

    public FormDTO createFormDTO() {
        return new FormDTO(numberOfTimes, datasourceUrl, datasourceUsername, datasourcePassword);
    }
}