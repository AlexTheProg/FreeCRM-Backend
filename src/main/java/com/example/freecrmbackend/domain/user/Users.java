package com.example.freecrmbackend.domain.user;

import com.example.freecrmbackend.infrastructure.exception.custom.UserAlreadyRegisteredException;

import java.util.Optional;

public interface Users {

    Optional<User> findUserByUsername(String username);
    void save(User user) throws UserAlreadyRegisteredException;

    Optional<User> findByEmail(String email);
}
