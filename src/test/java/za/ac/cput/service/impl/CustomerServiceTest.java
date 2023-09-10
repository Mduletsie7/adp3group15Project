/*
CustomerServiceTest.java
Tests the customer service
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
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.CustomerService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerServiceImpl;

    private static Customer customer =  CustomerFactory.createCustomer("Tom", "Ford", "0693618412", "tf@gmail.com");

    @Test
    void a_create(){
        System.out.print("Created: ");
        Customer created = customerServiceImpl.create(customer);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read(){
        System.out.println("Read: ");
        Customer read = customerServiceImpl.read(customer.getCustomerId());
        assertEquals(read.getCustomerId(), customer.getCustomerId());
        System.out.println(read);
    }

    @Test
    void c_update(){
        System.out.println("Updated: ");
        Customer updated = customerServiceImpl.update(new Customer.Builder().copy(customer).setPhoneNumber("069457831").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void d_delete(){
        System.out.println("Deleted: ");
        boolean success = customerServiceImpl.delete(customer.getCustomerId());
        assertTrue(success);
        System.out.println(success);
    }

    @Test
    void e_getAll(){
        System.out.println("Get all: ");
        System.out.println(customerServiceImpl.getAll());
    }


}
