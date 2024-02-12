package org.example.springsecurityfundamentals.config.security.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import org.example.springsecurityfundamentals.config.security.authentications.CustomAuthentication;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Value("${key}")
    String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication customAuthentication = (CustomAuthentication) authentication;

        String caKey = customAuthentication.getKey();

        if (caKey.equals(key))
            return new CustomAuthentication(false,null);

        throw new BadCredentialsException("Oh no! Bad key!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
