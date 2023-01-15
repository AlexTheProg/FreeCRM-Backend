package com.example.freecrmbackend.infrastructure.exception;

import com.example.freecrmbackend.infrastructure.exception.custom.UserAlreadyRegisteredException;
import com.example.freecrmbackend.infrastructure.exception.custom.UserNotFoundException;
import com.google.protobuf.Api;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserAlreadyRegisteredException.class})
    public ResponseEntity<Object> handleUserAlreadyRegisteredException(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        return new ResponseEntity<>(
                new ApiError(
                        status,
                        "User is already registered",
                        ex.getMessage()
                ),
                status
        );
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(Exception ex) {
        HttpStatus status = HttpStatus.OK;

        return new ResponseEntity<>(
                new ApiError(
                        status,
                        "User was not found",
                        ex.getMessage()
                ),
                status
        );
    }
}
