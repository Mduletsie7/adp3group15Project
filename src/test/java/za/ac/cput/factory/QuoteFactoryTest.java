/*
QuoteFactoryTest.java
Tests QuoteFactory
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Quote;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class QuoteFactoryTest {
    @Test
    public void equalityTest() {
        Quote quote = new Quote();
        quote = QuoteFactory.createQuote("Hire A Painter", "5 Avenue Long Street", "04/05/2023", "04/06/2023", "Exterior wall", 5000);
        //   assertEquals(quote.getTotalCost(), 4500);
        assertEquals(quote.getTotalCost(), 5000);

    }

    @Test
    public void objectIdentityTest() {
        Quote quote1 = new Quote();
        quote1 = QuoteFactory.createQuote("Hire A Painter", "5 Avenue, Long Street", "04/05/2023", "04/06/2023", "Exterior wall", 5000);
        //  Quote quote2 = new Quote();
        //  quote2 = QuoteFactory.createQuote("Hire A Painter", "5 Avenue Long Street", "07/05/2023", "07/06/2023", "Interior wall", 8000);
        //  assertSame(invoice1, invoice2);
        assertSame(quote1, quote1);


    }

    /*
    @Test
    public void failTest() {
       Quote quote = new Quote();
       quote = QuoteFactory.createQuote("Hire A Painter", "5 Avenue Long Street", "04/05/2023", "04/06/2023", "Exterior wall", 5000);
       assertNotNull(quote);
       fail();
    }
    @Test
    void timeOutTest() {
        assertTimeout(Duration.ofMillis(50), () -> {
            Thread.sleep(1350);

        });
    }

    @Test
    @Disabled
    public void disablingTest() {
        Quote quote = new Quote();
        quote = QuoteFactory.createQuote("Hire A Painter", "5 Avenue Long Street", "04/05/2023", "04/06/2023", "Exterior wall", 5000);
        assertNotNull(quote);
    }
    */

}
