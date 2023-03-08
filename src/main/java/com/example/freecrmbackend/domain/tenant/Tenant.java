package com.example.freecrmbackend.domain.tenant;

import com.google.common.cache.LoadingCache;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import javax.sql.DataSource;


@Entity
public class Tenant {

    @Id
    private String tenantId;
    private String db;
    private String password;
    private String url;
}
