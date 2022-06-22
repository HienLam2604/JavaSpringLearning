package com.example.JavaSpringLearning.jwt.models;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public class AuthenticationResponse {
    private final String jwt;
    private List<String> authorities;
    public String getJwt() {
        return jwt;
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

}
