package com.example.processmanagement.application.error;

public class SERApiException extends RuntimeException {
    public SERApiException(String message, Exception exception) {
        super(message, exception);
    }
}
