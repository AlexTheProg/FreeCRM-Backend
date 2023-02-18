package com.example.freecrmbackend.infrastructure.multitenancy;

import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.AbstractMultiTenantConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MultitenantConnectionProvider extends AbstractMultiTenantConnectionProvider {

    public static final MultitenantConnectionProvider INSTANCE = new MultitenantConnectionProvider();

    private final Map<String, ConnectionProvider> connectionProviderMap = new HashMap<>();

    Map<String, ConnectionProvider> getConnectionProviderMap() {
        return connectionProviderMap;
    }
    @Override
    protected ConnectionProvider getAnyConnectionProvider() {
        return connectionProviderMap.get(
                TenantContext.getCurrentTenant()
        );
    }

    @Override
    protected ConnectionProvider selectConnectionProvider(String tenantIdentifier) {
        return connectionProviderMap.get(
                tenantIdentifier
        );
    }

    private void addTenantConnectionProvider(String tenantId, DataSource tenantDataSource,
                                             Map<String, Object> properties) {
        var connectionProvider = new DatasourceConnectionProviderImpl();
        connectionProvider.setDataSource(tenantDataSource);
        connectionProvider.configure(properties);

        MultitenantConnectionProvider.INSTANCE
                .getConnectionProviderMap()
                .put(tenantId, connectionProvider);
    }
}
