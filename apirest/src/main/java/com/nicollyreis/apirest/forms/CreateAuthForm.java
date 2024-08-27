package com.nicollyreis.apirest.forms;

import com.nicollyreis.apirest.models.Auth;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAuthForm {

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
    public Auth convert(){

        Auth auth  = new Auth();
        auth.setEmail(this.getEmail());
        auth.setLogin(this.getLogin());
        auth.setSenha(this.getSenha());

        return auth;
    }

}



