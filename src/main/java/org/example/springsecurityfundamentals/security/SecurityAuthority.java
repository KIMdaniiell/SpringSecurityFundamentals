package org.example.springsecurityfundamentals.security;

import lombok.RequiredArgsConstructor;
import org.example.springsecurityfundamentals.entities.Authority;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    final Authority authority;

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
