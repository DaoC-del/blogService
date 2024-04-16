package com.background.commonSecurity.exception;

import org.springframework.http.HttpStatus;

public class ArticleNotFoundException extends ApplicationException {
    public ArticleNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
