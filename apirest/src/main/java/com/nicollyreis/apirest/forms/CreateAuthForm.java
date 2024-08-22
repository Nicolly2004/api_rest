package com.nicollyreis.apirest.forms;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAuthForm {

    @NotNull
    @Size(min = 6, max = 20)
    private String login;

    @NotNull
    @Size(min = 6, max = 12)
    private String senha;

    //conversão do form pra model
    public Auth convert(){

        Auth auth  = new Auth();
        auth.setLogin(this.getLogin());
        auth.setSenha(this.getSenha());

        return auth;
    }

}
