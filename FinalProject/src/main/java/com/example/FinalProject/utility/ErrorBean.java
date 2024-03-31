package com.example.FinalProject.utility;

import org.springframework.http.HttpStatus;

public class ErrorBean {

    private HttpStatus status;

    private String ErrorMessage;

    public HttpStatus getStatusCode() {
        return status;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.status = statusCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public ErrorBean(HttpStatus statusCode, String errorMessage) {
        this.status = statusCode;
        ErrorMessage = errorMessage;
    }

}
