package com.example.gitlite.core.exceptions;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class NotFoundException extends HttpStatusException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}