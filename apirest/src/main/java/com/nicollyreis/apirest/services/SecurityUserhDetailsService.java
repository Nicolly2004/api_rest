package com.nicollyreis.apirest.services;

import com.nicollyreis.apirest.models.Auth;
import com.nicollyreis.apirest.repositories.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityUserhDetailsService implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Auth> auth = this.authRepository.findByEmail(username);
        if (auth.isEmpty()){
            throw new UsernameNotFoundException("E-mail e/ou senha incorretos!");
        }
        return auth.get();
    }
}
