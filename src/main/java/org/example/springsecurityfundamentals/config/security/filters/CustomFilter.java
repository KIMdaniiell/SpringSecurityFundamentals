package org.example.springsecurityfundamentals.config.security.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.example.springsecurityfundamentals.config.security.authentications.CustomAuthentication;
import org.example.springsecurityfundamentals.config.security.managers.CustomAuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@AllArgsConstructor
public class CustomFilter extends OncePerRequestFilter {

    CustomAuthenticationManager customAuthenticationManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String requestKey = request.getHeader("key");

        // 1. Получить объект аутентификации
        CustomAuthentication authentication = new CustomAuthentication(false, requestKey);

        // 2. Делегировать проверку аутентификации менеджеру
        // 3. Получить от менеджера обновленный объект аутентификации
        var a  = customAuthenticationManager.authenticate(authentication);

        // 4. Обработать объект аутентификации
        if (a.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(a);
            filterChain.doFilter(request, response);
        }


    }
}
