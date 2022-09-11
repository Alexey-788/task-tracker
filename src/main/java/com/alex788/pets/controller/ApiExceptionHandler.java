package com.alex788.pets.controller;

import com.alex788.pets.exception.NotFoundException;
import com.alex788.pets.exception.UserDoesNotOwnEntityException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse notFound(NotFoundException exception) {
        HttpStatus code = HttpStatus.NOT_FOUND;
        String message = exception.getMessage();
        return new ErrorResponse(code.value(), message);
    }

    @ExceptionHandler(UserDoesNotOwnEntityException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse userDoesNotOwnEntity(UserDoesNotOwnEntityException exception) {
        HttpStatus code = HttpStatus.FORBIDDEN;
        String message = exception.getMessage();
        return new ErrorResponse(code.value(), message);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class ErrorResponse {

        private int code;
        private String message;
    }
}