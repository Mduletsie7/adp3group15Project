/*
CustomerSiteServiceTest.java
Tests the customer site service
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
import za.ac.cput.domain.CustomerSite;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.CustomerSiteFactory;
import za.ac.cput.service.CustomerSiteService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class CustomerSiteServiceTest {

    @Autowired
    private CustomerSiteService customerSiteServiceImpl;

    private static Customer customer = CustomerFactory.createCustomer("Tom", "Ford", "0693618412", "tf@gmail.com");

    private static CustomerSite customerSite =  CustomerSiteFactory.createCustomerSite(customer, "flat", "44 Ashville Street", "Cape Town", "Western Cape", 7054);

    @Test
    void a_create(){
        System.out.print("Created: ");
        CustomerSite created = customerSiteServiceImpl.create(customerSite);
        assertNotNull(created);
        System.out.println(created);
    }

    @Test
    void b_read(){
        System.out.println("Read: ");
        CustomerSite read = customerSiteServiceImpl.read(customerSite.getSiteId());
        assertEquals(read.getSiteId(), customerSite.getSiteId());
        System.out.println(read);
    }

    @Test
    void c_update(){
        System.out.println("Updated: ");
        CustomerSite updated = customerSiteServiceImpl.update(new CustomerSite.Builder().copy(customerSite).setStreet("12 Flick Street").build());
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void d_delete(){
        System.out.println("Deleted: ");
        boolean success = customerSiteServiceImpl.delete(customerSite.getSiteId());
        assertTrue(success);
        System.out.println(success);
    }

    @Test
    void e_getAll(){
        System.out.println("Get all: ");
        System.out.println(customerSiteServiceImpl.getAll());
    }


}
