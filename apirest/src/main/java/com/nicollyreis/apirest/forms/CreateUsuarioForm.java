package com.nicollyreis.apirest.forms;

import com.nicollyreis.apirest.models.Usuario;
import jakarta.validation.constraints. *;
import lombok.Data;

@Data
public class CreateUsuarioForm {
    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @Email
    @NotEmpty
    private String email;

    @NotNull
    @Size(min = 6, max = 20)
    private String login;

    @NotNull
    @Size(min = 6, max = 12)
    private String senha;

    //conversão do form pra model
    public Usuario convert(){

        Usuario usuario = new Usuario();
        usuario.setNome(this.getNome());
        usuario.setEmail(this.getEmail());
        usuario.setLogin(this.getLogin());
        usuario.setSenha(this.getSenha());

        return usuario;
    }


}
