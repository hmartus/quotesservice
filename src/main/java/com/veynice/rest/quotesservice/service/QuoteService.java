package com.veynice.rest.quotesservice.service;

import com.veynice.rest.quotesservice.model.Quote;

import java.util.List;

public interface QuoteService {

    Quote findById(long id);

    Quote findByQuote(String quote);

    void saveQuote(Quote quote);

    void updateQuote(Quote quote);

    void deleteQuoteById(long id);

    List<Quote> findAllQuotes();

    void deleteAllQuotes();

    boolean isQuoteExist(Quote quote);

    Quote randomQuote();

    List<Quote> randomTenQuotes();


}
