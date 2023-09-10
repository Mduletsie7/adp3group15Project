package za.ac.cput.service;

import za.ac.cput.domain.Quote;

import java.util.Set;

public interface IQuoteService extends IService<Quote, String>{
    public Set<Quote> getAll();
}
