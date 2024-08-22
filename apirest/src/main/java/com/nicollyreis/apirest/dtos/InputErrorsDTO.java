package com.nicollyreis.apirest.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InputErrorsDTO {

    private String campo;

    private String erro;
}
