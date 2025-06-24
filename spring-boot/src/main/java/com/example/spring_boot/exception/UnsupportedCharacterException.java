package com.example.spring_boot.exception;

public class UnsupportedCharacterException extends RuntimeException{
    public UnsupportedCharacterException(String message) {
        super(message);
    }
}
