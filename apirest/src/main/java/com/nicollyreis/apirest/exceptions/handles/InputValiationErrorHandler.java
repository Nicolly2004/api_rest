package com.nicollyreis.apirest.exceptions.handles;

import com.nicollyreis.apirest.dtos.InputErrorsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.List;

@RestControllerAdvice
public class InputValiationErrorHandler {

    @Autowired
    MessageSource messageSource;

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<InputErrorsDTO> handle(MethodArgumentNotValidException erro){
         List<FieldError> errorList = erro.getBindingResult().getFieldErrors();

         return errorList.stream().map(fieldError -> {
             String messagemErro = this.messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
             return new InputErrorsDTO(fieldError.getField(), messagemErro);
         }).toList();
    }

}
