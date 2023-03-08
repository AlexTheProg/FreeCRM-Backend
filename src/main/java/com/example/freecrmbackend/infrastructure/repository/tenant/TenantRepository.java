package com.example.freecrmbackend.infrastructure.repository.tenant;

import com.example.freecrmbackend.domain.tenant.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TenantRepository extends JpaRepository<Tenant, String> {
    Optional<Tenant> findTenantByTenantId(String id);
}
