package com.background.commonSecurity.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends ApplicationException {
    public InternalServerException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
