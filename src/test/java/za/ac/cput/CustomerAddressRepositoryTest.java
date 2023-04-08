/*
CustomerAddressRepositoryTest.java
Tests CustomerAddressRepository
Author: Anesu Bandama(221295755)
Date: 8 April 2023
*/
package za.ac.cput;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.CustomerAddress;
import za.ac.cput.factory.CustomerAddressFactory;
import za.ac.cput.repository.CustomerAddressRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class CustomerAddressRepositoryTest {
    private static CustomerAddressRepository repository = CustomerAddressRepository.getRepository();
    private static CustomerAddress customerAddress = CustomerAddressFactory.createCustomerAddress("5", "5");

    @Test
    void a_create() {
        CustomerAddress created = repository.create(customerAddress);
        assertNotNull(created);
        assertEquals(customerAddress.getCustomerAddressId(), created.getCustomerAddressId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        CustomerAddress read = repository.read(customerAddress.getCustomerAddressId());
        assertNotNull(read);
        System.out.println("Read: "+ read);

    }

    @Test
    void c_update() {
        CustomerAddress updated = new CustomerAddress.Builder().copy(customerAddress).setCustomerId("7").setAddressId("8")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(customerAddress.getCustomerAddressId());
        assertTrue(success);
        System.out.println("Deleted "+ success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}
