package com.alex788.pets.exception;

public class UserDoesNotOwnEntityException extends RuntimeException {

    public UserDoesNotOwnEntityException() {
        super();
    }

    public UserDoesNotOwnEntityException(String message) {
        super(message);
    }

    public UserDoesNotOwnEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
