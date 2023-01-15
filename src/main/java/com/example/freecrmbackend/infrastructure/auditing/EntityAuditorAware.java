package com.example.freecrmbackend.infrastructure.auditing;

import com.example.freecrmbackend.security.SecurityUser;
import lombok.NonNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;


public class EntityAuditorAware implements AuditorAware<String> {
    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        if (SecurityContextHolder.getContext().getAuthentication() == null) {
            return "User creation".describeConstable();
        }
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Optional.ofNullable(username);
    }
}
