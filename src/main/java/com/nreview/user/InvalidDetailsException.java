package com.nreview.user;

public class InvalidDetailsException extends RuntimeException {
    public InvalidDetailsException(String message) {
        super(message);
    }
}
