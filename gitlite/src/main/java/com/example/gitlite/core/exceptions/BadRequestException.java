package com.example.gitlite.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.Serial;

@ResponseStatus
public class BadRequestException extends HttpStatusCodeException {

    @Serial
    private static final long serialVersionUID = -3469366235536612338L;

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }

}