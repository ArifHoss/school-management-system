package com.example.spring_boot.exception;

public class NonUniqueResultException extends RuntimeException{
    public NonUniqueResultException(String message) {
        super(message);
    }
}
