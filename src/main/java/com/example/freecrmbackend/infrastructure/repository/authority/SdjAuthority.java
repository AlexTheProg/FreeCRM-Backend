package com.example.freecrmbackend.infrastructure.repository.authority;

import com.example.freecrmbackend.domain.user.authority.Authorities;
import com.example.freecrmbackend.domain.user.authority.Authority;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;


@Primary
@Repository
@RequiredArgsConstructor
public class SdjAuthority implements Authorities {

    private final AuthoritySdj authoritySdj;

    @Override
    public Optional<Set<Authority>> findAuthorityByName(String name) {
        return authoritySdj.findAuthorityByName(name);
    }
}
