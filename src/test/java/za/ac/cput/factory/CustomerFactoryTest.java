/*
CustomerFactoryTest.java
Tests the customer factory
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CustomerFactoryTest {
    @Test
    public void test(){
        Customer customer = CustomerFactory.createCustomer("Tom", "Ford", "0693618412", "tf@gmail.com");
        System.out.println(customer.toString());
        assertNotNull(customer);
    }
}
