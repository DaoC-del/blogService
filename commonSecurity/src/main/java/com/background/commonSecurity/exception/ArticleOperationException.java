package com.background.commonSecurity.exception;

import org.springframework.http.HttpStatus;

public class ArticleOperationException extends ApplicationException {
    public ArticleOperationException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
