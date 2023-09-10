/*
QuoteServiceTest.java
Tests the quote service
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/
package za.ac.cput.service.impl;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Quote;
import za.ac.cput.factory.QuoteFactory;
import za.ac.cput.service.QuoteService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class QuoteServiceTest {

    @Autowired
    private QuoteService quoteServiceImpl;

    private static Quote quote = QuoteFactory.createQuote("01/01/23", "01/03/23", 5000, true);

    @Test
    void a_create(){
        System.out.print("Created: ");
        Quote created = quoteServiceImpl.create(quote);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read(){
        System.out.println("Read: ");
        Quote read = quoteServiceImpl.read(quote.getQuoteNumber());
        assertEquals(read.getQuoteNumber(), quote.getQuoteNumber());
        System.out.println(read);
    }

    @Test
    void c_update(){
        System.out.println("Updated: ");
        Quote updated = quoteServiceImpl.update(new Quote.Builder().copy(quote).setTotalCost(25000).build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void d_delete(){
        System.out.println("Deleted: ");
        boolean success = quoteServiceImpl.delete(quote.getQuoteNumber());
        assertTrue(success);
        System.out.println(success);
    }

    @Test
    void e_getAll(){
        System.out.println("Get all: ");
        System.out.println(quoteServiceImpl.getAll());
    }


}
