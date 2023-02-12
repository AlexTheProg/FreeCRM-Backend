package com.example.freecrmbackend.exposition.user;

import org.springframework.lang.NonNull;

public record AddUserRequest(
        @NonNull
        String lastName,
        @NonNull
        String firstName,
        @NonNull
        String username,
        @NonNull
        String email
) {}
