/*
CustomerRepositoryTest.java
Tests CustomerRepository
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.repository.impl.CustomerRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class CustomerRepositoryTest {
    private static CustomerRepository repository = CustomerRepository.getRepository();
    private static Customer customer = CustomerFactory.createCustomer("Jon", "Doe", "0694323974","jdoe@gmail.com", "1");

    @Test
    void a_create() {
        Customer created = repository.create(customer);
        assertNotNull(created);
        assertEquals(customer.getCustomerId(), created.getCustomerId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Customer read = repository.read(customer.getCustomerId());
        assertNotNull(read);
        System.out.println("Read: "+ read);

    }

    @Test
    void c_update() {
        Customer updated = new Customer.Builder().copy(customer).setFirstName("Ben").setLastName("Care")
                .setPhoneNumber("0695543213").setEmailAddress("bcare@gmail.com").setAddressId("2").build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(customer.getCustomerId());
        assertTrue(success);
        System.out.println("Deleted "+ success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}