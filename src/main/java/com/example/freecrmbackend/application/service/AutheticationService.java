package com.example.freecrmbackend.application.service;

import com.example.freecrmbackend.domain.user.User;
import com.example.freecrmbackend.domain.user.Users;
import com.example.freecrmbackend.domain.user.authority.Authorities;
import com.example.freecrmbackend.exposition.request.auth.AuthenticationRequest;
import com.example.freecrmbackend.exposition.request.auth.RegisterRequest;
import com.example.freecrmbackend.exposition.response.auth.AuthenticationResponse;
import com.example.freecrmbackend.infrastructure.exception.custom.UserAlreadyRegisteredException;
import com.example.freecrmbackend.infrastructure.exception.custom.UserNotFoundException;
import com.example.freecrmbackend.security.SecurityUser;
import com.example.freecrmbackend.security.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AutheticationService {

    private final Users users;
    private final Authorities authorities;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var optUser = users.findByEmail(request.getEmail());

        try {
            var user = User.builder()
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .email(request.getEmail())
                    .authorities(authorities.findAuthorityByName("USER").orElse(null))
                    .build();

            users.save(user);
            var jwtToken = jwtService.generateToken(new SecurityUser(user));

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();

        } catch (Exception ex) {
            throw new UserAlreadyRegisteredException(ex.getMessage());
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        var user = users.findUserByUsername(request.getUsername())
                .orElseThrow(UserNotFoundException::new);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var jwtToken = jwtService.generateToken(new SecurityUser(user));

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}