package com.sab.learn.exception;

/**
 * BadRequestException custom exception is to returned for the domain
 * and handled accordingly from the controller
 */
public class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException() {
        super();
    }
}
