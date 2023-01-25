package com.example.freecrmbackend.security.service;

import com.example.freecrmbackend.domain.user.Users;
import com.example.freecrmbackend.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    private final Users users;
    @Override
    public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
        var u = users.findUserByUsername(username);

        return u.map(SecurityUser::new)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Username " + username + " not found"));
    }
}
