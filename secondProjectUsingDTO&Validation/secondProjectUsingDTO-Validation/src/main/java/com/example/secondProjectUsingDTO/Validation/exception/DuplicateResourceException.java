package com.example.secondProjectUsingDTO.Validation.exception;

public class DuplicateResourceException extends RuntimeException {
    public  DuplicateResourceException(String message){
        super(message);
    }
}
