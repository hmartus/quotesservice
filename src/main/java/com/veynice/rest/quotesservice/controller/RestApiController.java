package com.veynice.rest.quotesservice.controller;

import com.veynice.rest.quotesservice.model.Quote;
import com.veynice.rest.quotesservice.service.QuoteService;
import com.veynice.rest.quotesservice.exceptions.QuoteNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestApiController {

    @Autowired
    QuoteService quoteService;  //will do data retrieval and manipulation works

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> listAllQuotes() {
        List<Quote> quotes = quoteService.findAllQuotes();
        if (quotes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    //TODO: to implement with HATEOAS
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/quotes/{id}")
    public ResponseEntity<Quote> retrieveUser(@PathVariable int id){
        Quote quote = quoteService.findById(id);
        if(quote==null)
            throw new QuoteNotFoundException("id-"+ id);
        return new ResponseEntity<>(quote, HttpStatus.OK);
    }

}
