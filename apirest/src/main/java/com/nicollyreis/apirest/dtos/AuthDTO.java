package com.nicollyreis.apirest.dtos;

import com.nicollyreis.apirest.models.Auth;
import lombok.Data;

@Data
public class AuthDTO {
    private Long id;
    private String email;
    private String login;

    public AuthDTO(Auth auth){
        this.id = auth.getId();
        this.email = auth.getEmail();
        this.login = auth.getLogin();
    }
}
