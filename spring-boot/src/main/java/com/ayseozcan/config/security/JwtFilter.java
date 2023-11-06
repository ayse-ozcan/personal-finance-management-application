package com.ayseozcan.config.security;

import com.ayseozcan.exception.ErrorType;
import com.ayseozcan.exception.FinanceManagementException;
import com.ayseozcan.utility.JwtProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {
    JwtProvider jwtProvider;
    JwtUserDetails jwtUserDetails;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            Optional<String> userId = jwtProvider.getByIdFromToken(token);
            if (userId.isEmpty()) throw new FinanceManagementException(ErrorType.INVALID_TOKEN);
            UserDetails userDetails = jwtUserDetails.loadUserByUserId(userId.get());
            UsernamePasswordAuthenticationToken userSpringToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(userSpringToken);
        }
        filterChain.doFilter(request, response);
    }
}

