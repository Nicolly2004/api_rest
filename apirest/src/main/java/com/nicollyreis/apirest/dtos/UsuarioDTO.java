package com.nicollyreis.apirest.dtos;

import com.nicollyreis.apirest.models.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UsuarioDTO {

    private Long id;

    private String nome;

    private String email;

    private String login;

    private String senha;

    private Date createdAt;

    private Date updatedAt;

    public UsuarioDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome= usuario.getNome();
        this.email = usuario.getEmail();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.createdAt = usuario.getCreatedAt();
        this.updatedAt = usuario.getUpdatedAt();
    }
}
