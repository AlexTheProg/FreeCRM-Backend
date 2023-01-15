package com.example.freecrmbackend.infrastructure.repository.authority;

import com.example.freecrmbackend.domain.user.authority.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface AuthoritySdj extends JpaRepository<Authority, Integer> {
    Optional<Set<Authority>> findAuthorityByName(String name);
}
