package com.example.freecrmbackend.infrastructure.repository.user;

import com.example.freecrmbackend.domain.user.User;
import com.example.freecrmbackend.domain.user.Users;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Primary
@Repository
public class SdjUser implements Users {
    private final UserSdj springDataJpa;

    public SdjUser(UserSdj springDataJpa) {
        this.springDataJpa = springDataJpa;
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return springDataJpa.findUserByUsername(username);
    }

    @Override
    public void save(User user) {
        springDataJpa.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springDataJpa.findByEmail(email);
    }
}
