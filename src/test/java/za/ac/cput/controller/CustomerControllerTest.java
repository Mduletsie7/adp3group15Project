/*
CustomerControllerTest.java
Tests the customer controller
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
import za.ac.cput.factory.CustomerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {
private static Customer customer = CustomerFactory.createCustomer("Tom", "Ford", "0693618412", "tf@gmail.com");
@Autowired
private TestRestTemplate restTemplate;

private final String baseUrl = "http://localhost:8080/customer";
    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Customer savedCustomer = postResponse.getBody();
        assertEquals(customer.getCustomerId(), savedCustomer.getCustomerId());
        System.out.println("Saved customer: "+ savedCustomer);
    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + customer.getCustomerId();
        System.out.println("URL: " + url);
        ResponseEntity<Customer> response = restTemplate.getForEntity(url, Customer.class);
        assertEquals(customer.getCustomerId(), response.getBody().getCustomerId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Customer updated = new Customer.Builder().copy(customer).setFirstName("Temuso").build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, updated, Customer.class);
        assertNotNull(response.getBody());
    }

    @Disabled
    void e_delete() {
        String url = baseUrl + "/delete/" + customer.getCustomerId();
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
