/*
CustomerSiteFactoryTest.java
Tests the customer site factory
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerSite;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerSiteFactoryTest {

    Customer customer = CustomerFactory.createCustomer("Tom", "Ford", "0693618412", "tf@gmail.com");
    CustomerSite customerSite = new CustomerSite.Builder()
            .setCustomerId(customer)
            .setType("apartment")
            .setStreet("2 Flick Street")
            .setCity("Cape Town")
            .setProvince("Western Cape")
            .setPostalCode(8000)
            .build();

    @Test
    public void test(){
        CustomerSite customerSite = CustomerSiteFactory.createCustomerSite(customer, "flat", "Ashville", "Cape Town", "Western Cape", 7054);
        System.out.println(customerSite.toString());
        assertNotNull(customerSite);
    }
}
