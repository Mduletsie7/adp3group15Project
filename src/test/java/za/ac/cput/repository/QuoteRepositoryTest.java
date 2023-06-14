/*
QuoteRepositoryTest.java
Tests QuoteRepository
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Quote;
import za.ac.cput.factory.QuoteFactory;
import za.ac.cput.repository.impl.QuoteRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class QuoteRepositoryTest {
    private static QuoteRepository repository = QuoteRepository.getRepository();
    private static Quote quote = QuoteFactory.createQuote("Hire A Painter", "5 Avenue, Long Street", "05/07/2023","05/08/2023", "Exterior wall", 5000);

    @Test
    void a_create() {
        Quote created = repository.create(quote);
        assertNotNull(created);
        assertEquals(quote.getQuoteNumber(), created.getQuoteNumber());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Quote read = repository.read(quote.getQuoteNumber());
        assertNotNull(read);
        System.out.println("Read: "+ read);

    }

    @Test
    void c_update() {
        Quote updated = new Quote.Builder().copy(quote).setBusinessName("Hire A Painter").setBusinessAddress("5 Avenue, Long Street")
                .setIssueDate("07/06/2023").setExpiryDate("07/07/2023").setDescription("Interior Wall").setTotalCost(4000).build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(quote.getQuoteNumber());
        assertTrue(success);
        System.out.println("Deleted "+ success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}
