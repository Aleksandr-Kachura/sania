package com.test.servlet.exception;


import java.util.Map;

public class ValidationException extends Exception {

    private Map<String, String> error;

    public ValidationException(Map<String, String> error) {
        this.error = error;
    }

    public Map<String, String> getError() {
        return error;
    }


}