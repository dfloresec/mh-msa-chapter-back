package com.chapter.back.constant.dto;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiErrorDTO {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiErrorDTO() {
        super();
    }

    public ApiErrorDTO(final HttpStatus status, final String message, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = new ArrayList<>(errors);
    }

    public ApiErrorDTO(final HttpStatus status, final String message, final String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(final HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return new ArrayList<>(errors);
    }

    public void setErrors(final List<String> errors) {
        this.errors = new ArrayList<>(errors);
    }

    public void setError(final String error) {
        errors = Arrays.asList(error);
    }

}
