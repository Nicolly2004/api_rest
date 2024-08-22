package com.nicollyreis.apirest.controller;

import com.nicollyreis.apirest.dtos.AuthDTO;
import com.nicollyreis.apirest.forms.CreateAuthForm;
import com.nicollyreis.apirest.repositories.AuthRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthRepository authRepository;
    @PostMapping
    @Transactional
    public ResponseEntity<AuthDTO> create(@RequestBody @Valid CreateAuthForm form){
        Auth auth = form.convert();
        this.authRepository.save(auth);
        return new ResponseEntity<>(new AuthDTO(auth), HttpStatus.CREATED);
    }
}
