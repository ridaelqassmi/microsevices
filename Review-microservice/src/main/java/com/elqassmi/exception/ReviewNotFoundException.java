package com.elqassmi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class ReviewNotFoundException extends RuntimeException{
    private String message;
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
