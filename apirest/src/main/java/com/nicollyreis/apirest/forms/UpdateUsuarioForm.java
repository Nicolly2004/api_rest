package com.nicollyreis.apirest.forms;

import com.nicollyreis.apirest.models.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUsuarioForm {
    private String nome;

    @Email
    private String email;

    @Size(min = 6, max = 12)
    private String login;

    @Size(min = 6, max = 12)
    private String senha;

    public Usuario update(Usuario usuario){

        if(nome  != null) usuario.setNome(nome);
        if(email != null) usuario.setEmail(email);
        if(login != null) usuario.setLogin(login);
        if(senha != null) usuario.setSenha(senha);

        return usuario;
    }
}
