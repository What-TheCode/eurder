package com.example.eurder.exception;

public class NoAuthorizationException extends RuntimeException{
    public NoAuthorizationException(String message) {
        super(message);
    }
}
