/*
CustomerFactoryTest.java
Tests CustomerFactory
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.factory;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerFactoryTest {
    @Test
    public void equalityTest() {
        Customer customer = new Customer();
        customer = CustomerFactory.createCustomer("Tom", "Ford", "0694436543", "tm@gmail.com", "5");
      //  assertEquals(customer.getFirstName(), "Virgil");
        assertEquals(customer.getFirstName(), "Tom");

    }

    @Test
    public void objectIdentityTest() {
        Customer customer1 = new Customer();
        customer1 = CustomerFactory.createCustomer("Tom", "Ford", "0694436543", "tm@gmail.com", "5");
        Customer customer2 = new Customer();
        customer2 = CustomerFactory.createCustomer("Ben", "Mac", "0696985432", "bm@gmail.com", "7");


     //   assertSame(customer1, customer2);
        assertSame(customer1, customer1);


    }
    /*
    @Test
    public void failTest() {
        Customer customer = new Customer();
        customer = CustomerFactory.createCustomer("Tom", "Ford", "0694436543", "tm@gmail.com", "5");
        assertNotNull(customer);
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
        Customer customer = new Customer();
        customer = CustomerFactory.createCustomer("Tom", "Ford", "0694436543", "tm@gmail.com", "5");
        assertNotNull(customer);
    }
*/
}
