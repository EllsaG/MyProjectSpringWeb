package com.myproject.exceptions;

public class IncorrectNumberValueException extends RuntimeException{
    public IncorrectNumberValueException(String message) {
        super(message);
    }
}
