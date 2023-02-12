package com.example.freecrmbackend.infrastructure.multitenancy;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

//must get tenantID before hitting any endpoint of the application
//tenant filter must execute first
@Component
@Order(1)
public class TenantFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String tenantName = request.getHeader("X-tenantID");
        TenantContext.setCurrentTenant(tenantName);

        try {
            filterChain.doFilter(servletRequest, servletResponse); //pass the control down the chain
        } finally {
            //ensure reset before the next request
            //avoid cross-tenant request contamination
            TenantContext.setCurrentTenant("");
        }
    }
}
