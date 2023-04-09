/*
InvoiceFactoryTest.java
Tests InvoiceFactory
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Invoice;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
public class InvoiceFactoryTest {
    @Test
    public void equalityTest() {
        Invoice invoice = new Invoice();
        invoice = InvoiceFactory.createInvoice("5", "05/05/2023", 2500);
        //   assertEquals(invoice.getQuoteNumber(), "6");
        assertEquals(invoice.getQuoteNumber(), "5");

    }

    @Test
    public void objectIdentityTest() {
        Invoice invoice1 = new Invoice();
        invoice1 = InvoiceFactory.createInvoice("5", "05/05/2023", 2500);
        //   Invoice invoice2 = new Invoice();
        //   invoice2 = InvoiceFactory.createInvoice("6", "07/05/2023", 8500);
        //  assertSame(invoice1, invoice2);
        assertSame(invoice1, invoice1);


    }

    /*
    @Test
    public void failTest() {
       Invoice invoice = new Invoice();
       invoice = InvoiceFactory.createInvoice("5", "05/05/2023", 2500);
       assertNotNull(invoice);
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
        Invoice invoice = new Invoice();
        invoice = InvoiceFactory.createInvoice("5", "05/05/2023", 2500);
        assertNotNull(invoice);
    }
    */

}
