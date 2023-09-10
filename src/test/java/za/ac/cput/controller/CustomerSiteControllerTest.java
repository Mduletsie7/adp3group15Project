/*
CustomerSiteControllerTest.java
Tests the customer site controller
Author: Anesu Bandama(221295755)
Date: 10 September 2023
*/

package za.ac.cput.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CustomerSite;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.factory.CustomerSiteFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerSiteControllerTest {

private static Customer customer = CustomerFactory.createCustomer("Tom", "Ford", "0693618412", "tf@gmail.com");

private static CustomerSite customerSite = CustomerSiteFactory.createCustomerSite(customer, "flat", "Ashville", "Cape Town", "Western Cape", 7054);

@Autowired
private TestRestTemplate restTemplate;

private final String baseUrl = "http://localhost:8080/customerSite";
    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<CustomerSite> postResponse = restTemplate.postForEntity(url, customerSite, CustomerSite.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        CustomerSite savedCustomerSite = postResponse.getBody();
        System.out.println("Saved data: " + savedCustomerSite);
        assertEquals(customerSite.getSiteId(), savedCustomerSite.getSiteId());
    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + customerSite.getSiteId();
        System.out.println("URL: " + url);
        ResponseEntity<CustomerSite> response = restTemplate.getForEntity(url, CustomerSite.class);
        assertEquals(customerSite.getSiteId(), response.getBody().getSiteId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        CustomerSite updated = new CustomerSite.Builder().copy(customerSite).setStreet("11 Flowton Street").build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<CustomerSite> response = restTemplate.postForEntity(url, updated, CustomerSite.class);
        assertNotNull(response.getBody());
    }

    @Disabled
    void e_delete() {
        String url = baseUrl + "/delete/" + customerSite.getSiteId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseUrl + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show ALL: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}
