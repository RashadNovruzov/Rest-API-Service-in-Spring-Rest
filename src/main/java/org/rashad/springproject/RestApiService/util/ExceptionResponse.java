package org.rashad.springproject.RestApiService.util;

public class SensorExceptionResponse {
    private String errorMessage;

    public SensorExceptionResponse() {
    }

    public SensorExceptionResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
