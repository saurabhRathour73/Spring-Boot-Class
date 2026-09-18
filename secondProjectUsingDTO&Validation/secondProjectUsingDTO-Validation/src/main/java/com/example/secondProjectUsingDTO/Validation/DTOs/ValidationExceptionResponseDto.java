package com.example.secondProjectUsingDTO.Validation.DTOs;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionResponseDto {
    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;
    private Map<String,String> filedErrors;

    public ValidationExceptionResponseDto(
            LocalDateTime timestamp,
            int statusCode, String error,
            String message,
            String path,
            Map<String, String> filedErrors
    ) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
        this.filedErrors = filedErrors;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getFiledErrors() {
        return filedErrors;
    }

    public void setFiledErrors(Map<String, String> filedErrors) {
        this.filedErrors = filedErrors;
    }
}
