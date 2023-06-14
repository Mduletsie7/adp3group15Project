/*
QuoteRepository.java
Entity for the quote repository
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.repository.impl;

import za.ac.cput.domain.Quote;
import za.ac.cput.repository.IQuoteRepository;

import java.util.HashSet;
import java.util.Set;

public class QuoteRepository implements IQuoteRepository {
    private static QuoteRepository repository = null;
    private Set<Quote> quoteDB = null;

    private QuoteRepository(){
        quoteDB = new HashSet<Quote>();
    }

    public static QuoteRepository getRepository(){
        if(repository == null){
            repository = new QuoteRepository();
        }
        return repository;
    }


    @Override
    public Quote create(Quote quote) {
        boolean success = quoteDB.add(quote);
        if(!success){
            return null;
        }
        return quote;
    }

    @Override
    public Quote read(String quoteId) {
        // linear or sequential search
       /* for (Quote q : quoteDB){
            if(q.getQuoteId().equalsIgnoreCase(quoteId)){
                return q;
            }

        }
        return null;
*/
        // Lambda expressions Java 8
        Quote quote = quoteDB.stream().
                filter(q -> q.getQuoteNumber()
                        .equals(quoteId)).
                findAny()
                .orElse(null);
        return quote;
    }

    @Override
    public Quote update(Quote quote) {
        Quote oldQuote = read(quote.getQuoteNumber());
        if(oldQuote != null){
            quoteDB.remove(oldQuote);
            quoteDB.add(quote);
            return quote;
        }
        return null;
    }

    @Override
    public boolean delete(String quoteNumber) {
        Quote quoteToDelete = read(quoteNumber);
        if(quoteToDelete == null) {
            return false;
        }
        quoteDB.remove(quoteToDelete);
        return true;
    }

    @Override
    public Set<Quote> getAll() {
        return quoteDB;
    }

}
