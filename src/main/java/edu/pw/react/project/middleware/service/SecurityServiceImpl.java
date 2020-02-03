package edu.pw.react.project.middleware.service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
class SecurityServiceImpl implements SecurityService {

    private static final String SECURITY_HEADER = "security_header";
    private final String SECURITY_HEADER_VALUE = "someExtremelyRandomCode!@#$%^&*()";

    @Override
    public boolean isAuthenticated(HttpHeaders headers) {
        if (headers == null) {
            return false;
        }
        return headers.containsKey(SECURITY_HEADER) && SECURITY_HEADER_VALUE.equals(headers.getFirst(SECURITY_HEADER));
    }

    @Override
    public boolean isAuthorized(HttpHeaders headers) {
        return isAuthenticated(headers);
    }
}