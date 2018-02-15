package com.veynice.rest.quotesservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class QuoteNotFoundException extends RuntimeException{
    public QuoteNotFoundException(String s){
        super(s);
    }
}
