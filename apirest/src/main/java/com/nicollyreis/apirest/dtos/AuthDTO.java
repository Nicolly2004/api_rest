package com.nicollyreis.apirest.dtos;

import lombok.Data;


@Data
public class AuthDTO  {
    private Long id;

    private String nome;

    private String email;

    private String login;

    private String senha;

    public AuthDTO(Auth auth){
        this.id = auth.getId();
        this.nome= auth.getNome();
        this.email = auth.getEmail();
        this.login = auth.getLogin();
        this.senha = auth.getSenha();

    }
}
