package com.offsidegaming.monitoringapplication.rest.filter;

import com.offsidegaming.monitoringapplication.utils.SessionContextUtil;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class MonitoringApplicationFilter implements ContainerRequestFilter {

    private static final String USER_SESSION_HEADER = "USER_SESSION";

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        if (containerRequestContext.getHeaders().containsKey(USER_SESSION_HEADER)) {
            SessionContextUtil.setUserSession(containerRequestContext.getHeaderString(USER_SESSION_HEADER));
        }
    }

}