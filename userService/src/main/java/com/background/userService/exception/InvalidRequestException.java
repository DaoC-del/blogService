package com.background.userService.exception;

import org.springframework.http.HttpStatus;

public class InvalidRequestException extends ApplicationException {
    public InvalidRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
