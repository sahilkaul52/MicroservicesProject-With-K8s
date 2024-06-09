package com.example.gatewayserver.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


public class KeycloakRoleConverter  implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    public Collection<GrantedAuthority> convert(Jwt source) {

        Map<String, Object> realmAccess = (Map<String, Object>) source.getClaims().get("realm_access");

        if (realmAccess == null || realmAccess.isEmpty())
        {
            return new ArrayList<>();
        }

        List<String> roles = (List<String>) realmAccess.get("roles");
        Collection<GrantedAuthority> returnValue = new ArrayList<>();

        for(String role: roles)
        {
            role= "ROLE_"+ role;
            returnValue.add(new SimpleGrantedAuthority(role));
        }

        return returnValue;
    }

}
