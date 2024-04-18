package com.background.commonSecurity.exception;

import org.springframework.http.HttpStatus;

public class OperationFailedException  extends ApplicationException{
    public OperationFailedException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
