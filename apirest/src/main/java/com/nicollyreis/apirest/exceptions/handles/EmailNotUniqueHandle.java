package com.nicollyreis.apirest.exceptions.handles;

import com.nicollyreis.apirest.dtos.InputErrorsDTO;
import com.nicollyreis.apirest.exceptions.EmailNotUniqueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmailNotUniqueHandle {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(EmailNotUniqueException.class)
    public InputErrorsDTO handle(EmailNotUniqueException erro){
        return new InputErrorsDTO("email", erro.getMessage());
    }
}
