package com.example.freecrmbackend.infrastructure.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.freecrmbackend.domain.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserSdj extends JpaRepository<User, Integer> {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    Optional<User> findUserByUsername(String username);

    Optional<User> findByEmail(String email);

}
