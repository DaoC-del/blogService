package com.background.userService.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationFailureException extends ApplicationException {
    public AuthenticationFailureException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
