/**
 * PaymentControllerTest.java
 * This is the Consultant POJO
 * @author Lerato Moshabi - 220076073
 * 14 August 2023
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
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PaymentControllerTest {

    private static Payment payment = PaymentFactory.createPayment("R5000", "28 August 2023");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8080/payment";
    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(url, payment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Payment savedPayment = postResponse.getBody();
        System.out.println("Saved data: " + savedPayment);
        assertEquals(payment.getPaymentId(), savedPayment.getPaymentId());


    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + payment.getPaymentId();
        System.out.println("URL: " + url);
        ResponseEntity<Payment> response = restTemplate.getForEntity(url, Payment.class);
        assertEquals(payment.getPaymentId(), response.getBody().getPaymentId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Payment updated = new Payment.Builder().copy(payment).setPaymentAmount("R7000").build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Payment> response = restTemplate.postForEntity(url, updated, Payment.class);
        assertNotNull(response.getBody());
    }

    @Disabled
    void e_delete() {
        String url = baseUrl + "/delete/" + payment.getPaymentId();
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