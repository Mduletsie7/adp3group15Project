/*
QuoteController.java
Entity for the quote controller
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Quote;
import za.ac.cput.service.impl.QuoteServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/quote")
public class QuoteController {

    private QuoteServiceImpl service;

    @Autowired
    QuoteController(QuoteServiceImpl service){
        this.service = service;
    }

    @PostMapping("/create")
    public Quote create(@RequestBody Quote quote){
        return service.create(quote);
    }

    @GetMapping("/read/{id}")
    public Quote read(@PathVariable String id){
        return service.read(id);
    }

    @PostMapping("/update")
    public Quote update(@RequestBody Quote quote){
        return service.update(quote);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Quote> getAll(){
        return service.getAll();
    }


}
