/*
QuoteFactoryTest.java
Tests the quote factory
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Quote;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class QuoteFactoryTest {
    @Test
    public void test(){
        Quote quote = QuoteFactory.createQuote("01/01/23", "01/03/23", 5000, true);
        System.out.println(quote.toString());
        assertNotNull(quote);
    }
}
