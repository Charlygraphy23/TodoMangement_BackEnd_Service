package com.example.webserver.reactwebserver2.jwt.resourse;

class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
