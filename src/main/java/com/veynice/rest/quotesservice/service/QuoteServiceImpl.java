package com.veynice.rest.quotesservice.service;

import com.veynice.rest.quotesservice.model.Quote;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class QuoteServiceImpl implements QuoteService {
    private static final AtomicLong counter = new AtomicLong();
    private static List<Quote> quotes;

    static{
        quotes = populateDummyQuotes();
    }

    @Override
    public Quote findById(long id) {
        for(Quote quote : quotes){
            if(quote.getId() == id){
                return quote;
            }
        }
        return null;
    }

    @Override
    public Quote findByQuote(String quote) {
        for(Quote quote1 : quotes){
            if(quote1.getQuote().equalsIgnoreCase(quote)){
                return quote1;
            }
        }
        return null;
    }

    @Override
    public void saveQuote(Quote quote) {
        quote.setId(counter.incrementAndGet());
        quotes.add(quote);
    }

    @Override
    public void updateQuote(Quote quote) {
        int index = quotes.indexOf(quote);
        quotes.set(index, quote);
    }

    @Override
    public void deleteQuoteById(long id) {
        for (Iterator<Quote> iterator = quotes.iterator(); iterator.hasNext(); ) {
            Quote quote = iterator.next();
            if (quote.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public List<Quote> findAllQuotes() {
        return quotes;
    }

    @Override
    public void deleteAllQuotes() {
        quotes.clear();
    }

    @Override
    public boolean isQuoteExist(Quote quote) {
        return findByQuote(quote.getQuote())!=null;
    }

    @Override
    public Quote randomQuote() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, quotes.size() + 1);
        return findById(randomNum);
    }

    @Override
    public List<Quote> randomTenQuotes() {
        List<Quote> q = new ArrayList<>();
        for(int i = 0 ; i < 10 ; i++){
            q.add(randomQuote());
        }
        return q;
    }

    private static List<Quote> populateDummyQuotes(){
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote(counter.incrementAndGet(),"To be or not to be, really?","jHurvz"));
        quotes.add(new Quote(counter.incrementAndGet(),"All izz well, bowel","jHurvzsS"));
        quotes.add(new Quote(counter.incrementAndGet(),"This is it pansit!, wew!","hHARVEYy"));
        quotes.add(new Quote(counter.incrementAndGet(),"The wells on the bus","Harvey the grit"));
        quotes.add(new Quote(counter.incrementAndGet(),"Put a tank in a mall? How? ","HarVEY"));
        return quotes;
    }


}
