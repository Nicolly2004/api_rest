package com.nicollyreis.apirest.exceptions;

public class EmailNotUniqueException extends RuntimeException {
    public EmailNotUniqueException(){
        super("O campo email precisa ser único");
    }
}
