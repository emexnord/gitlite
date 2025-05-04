package com.example.gitlite.core.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serial;

@RequiredArgsConstructor
@Getter
public class HttpStatusException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;
    private final String message;
}
