package com.example.freecrmbackend.application.service.user;

import com.example.freecrmbackend.domain.user.User;
import com.example.freecrmbackend.domain.user.Users;
import com.example.freecrmbackend.exposition.request.user.AddUserRequest;
import com.example.freecrmbackend.security.service.PasswordGeneratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

import javax.annotation.security.RolesAllowed;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final Users users;
    private final PasswordGeneratorService passwordGeneratorService;

    @RolesAllowed({"ROLE_USER"})
    public User addUser(AddUserRequest request){

        var password = PasswordEncoderFactories
                .createDelegatingPasswordEncoder()
                .encode(passwordGeneratorService.generatePassword());

        var user = User.builder()
                .username(request.username())
                .password(password)
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        log.info("Principal user {}", SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray());
        users.save(user);

        return user;
    }

}
