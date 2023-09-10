package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Quote;
import za.ac.cput.repository.IQuoteRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuoteService implements IQuoteService {

    private IQuoteRepository repository;

    @Autowired
    private QuoteService(IQuoteRepository repository){
        this.repository = repository;
    }

    @Override
    public Quote create(Quote quote){
        return this.repository.save(quote);
    }

    @Override
    public Quote read(String quoteId){
        return this.repository.findById(quoteId).orElse(null);
    }

    @Override
    public Quote update(Quote quote){
        if(this.repository.existsById(quote.getQuoteNumber())){
            return this.repository.save(quote);
        }
        return null;
    }
    @Override
    public boolean delete(String quoteId){
        if(this.repository.existsById(quoteId)){
            this.repository.deleteById(quoteId);
            return true;
        }
        return false;
    }

    @Override
    public Set<Quote> getAll(){
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }


}
