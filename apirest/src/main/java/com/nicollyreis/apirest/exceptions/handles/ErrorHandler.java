package com.nicollyreis.apirest.exceptions.handles;

import com.nicollyreis.apirest.dtos.ErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
@RestControllerAdvice
public class ErrorHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ErroDTO handle(SQLIntegrityConstraintViolationException erro){

        return new ErroDTO(erro.getMessage());
    }
}
