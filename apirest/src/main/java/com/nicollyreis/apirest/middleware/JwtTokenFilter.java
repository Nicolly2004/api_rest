package com.nicollyreis.apirest.middleware;

import com.nicollyreis.apirest.services.JwtService;
import com.nicollyreis.apirest.services.SecurityUserhDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

    private JwtService jwtService;

    private SecurityUserhDetailsService userDetailsService;

    public JwtTokenFilter(JwtService jwtService,SecurityUserhDetailsService userDetailsService){
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
          String token = authorizationHeader.split(" ")[1];
        }
    }
}
