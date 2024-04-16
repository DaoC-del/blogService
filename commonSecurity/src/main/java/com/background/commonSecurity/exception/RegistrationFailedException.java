package com.background.commonSecurity.exception;

import org.springframework.http.HttpStatus;

public class RegistrationFailedException extends RuntimeException {
    private final HttpStatus status;

    public RegistrationFailedException(String message) {
        super(message);
        this.status = HttpStatus.BAD_REQUEST; // 或者其他适当的状态码
    }

    public HttpStatus getStatus() {
        return status;
    }
}
