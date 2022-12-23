package com.example.processmanagement.boundary.client.error;

public class ProcessNotFoundException extends RuntimeException {
    public ProcessNotFoundException(String message) {
        super(message);
    }
}
