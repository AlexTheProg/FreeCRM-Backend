package com.example.freecrmbackend.infrastructure.exception.custom;

import javax.naming.AuthenticationException;

public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException(final String msg) {
        super(msg);
    }
}
