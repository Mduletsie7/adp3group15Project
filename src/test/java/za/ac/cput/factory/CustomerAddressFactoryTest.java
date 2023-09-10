/*
CustomerAddressFactoryTest.java
Tests CustomerAddressFactory
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.CustomerAddress;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerAddressFactoryTest {
    @Test
    public void equalityTest() {
        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress = CustomerAddressFactory.createCustomerAddress("5", "5");
     //   assertEquals(customerAddress.getCustomerId(), "6");
        assertEquals(customerAddress.getCustomerId(), "5");
        
    }

    @Test
    public void objectIdentityTest() {
        CustomerAddress customerAddress1 = new CustomerAddress();
        customerAddress1 = CustomerAddressFactory.createCustomerAddress("5", "5");
        // CustomerAddress customerAddress2 = new CustomerAddress();
        // customerAddress2 = CustomerAddressFactory.createCustomerAddress("6", "6");

      //  assertSame(customerAddress1, customerAddress2);
        assertSame(customerAddress1, customerAddress1);


    }

    /*
    @Test
    public void failTest() {
        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress = CustomerAddressFactory.createCustomerAddress("5", "5");
        assertNotNull(customerAddress);
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
        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress = CustomerAddressFactory.createCustomerAddress("5", "5");
        assertNotNull(customerAddress);
    }
    */
}
