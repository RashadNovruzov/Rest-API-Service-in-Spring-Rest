package org.rashad.springproject.RestApiService.util;

public class ExceptionResponse {
    private String errorMessage;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
