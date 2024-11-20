package com.example.demo;

public class BookIdMismatchException extends RuntimeException {

    public BookIdMismatchException() {
        super();
    }

    public BookIdMismatchException(String message) {
        super(message);
    }

    public BookIdMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
