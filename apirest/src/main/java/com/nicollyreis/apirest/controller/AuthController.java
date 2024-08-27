package com.nicollyreis.apirest.controller;

import com.nicollyreis.apirest.dtos.AuthDTO;
import com.nicollyreis.apirest.dtos.LoginDTO;
import com.nicollyreis.apirest.exceptions.EmailNotUniqueException;
import com.nicollyreis.apirest.forms.CreateAuthForm;
import com.nicollyreis.apirest.forms.LoginForm;
import com.nicollyreis.apirest.models.Auth;
import com.nicollyreis.apirest.repositories.AuthRepository;
import com.nicollyreis.apirest.services.JwtService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

@RestController
@RequestMapping("/autenticar")
public class AuthController {

    private AuthRepository authRepository;

    private PasswordEncoder encoder;

    private JwtService jwtService;

    public  AuthController(AuthRepository repository,PasswordEncoder encoder, JwtService jwtService){
        this.authRepository = repository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity<AuthDTO> create(@RequestBody @Valid CreateAuthForm createAuthForm) {
        Auth auth = createAuthForm.convert();
        Optional<Auth> authExiste = this.authRepository.findByEmail(createAuthForm.getEmail());

        if (authExiste.isPresent()) {
            throw new EmailNotUniqueException();
        }

        auth.setSenha(encoder.encode(createAuthForm.getSenha()));
        this.authRepository.save(auth);
        return new ResponseEntity<>(new AuthDTO(auth), HttpStatus.CREATED);
    }
        @PostMapping("/login")
        public ResponseEntity<LoginDTO> login(@RequestBody @Valid LoginForm  form){;

            Optional<Auth> auth = this.authRepository.findByEmail(form.getEmail());

            if (auth.isEmpty()){
                throw new UsernameNotFoundException("Email e/ou senha incorretos");
            }

            Auth authEncontrado = auth.get();

            boolean passwordCorrect  = this.encoder.matches(form.getSenha(),authEncontrado.getPassword());

            if (!passwordCorrect){
                throw new UsernameNotFoundException("Email e/ou senha incorretos");
            }

           try{
               String token = this.jwtService.gerarToken(authEncontrado);
               return new ResponseEntity<>(new LoginDTO("Bearer",token),HttpStatus.CREATED);
           }catch (UnsupportedEncodingException e){
               throw new RuntimeException(e);
           }

    }

}