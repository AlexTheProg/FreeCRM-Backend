package com.example.freecrmbackend.domain.user.authority;

import java.util.Optional;
import java.util.Set;

public interface Authorities {

    Optional<Set<Authority>> findAuthorityByName(String name);
}
