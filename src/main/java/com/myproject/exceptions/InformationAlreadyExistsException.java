package com.myproject.exceptions;

public class InformationAlreadyExistsException extends RuntimeException{
    public InformationAlreadyExistsException(String message) {
        super(message);
    }
}
