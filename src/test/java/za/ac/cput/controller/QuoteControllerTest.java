/*
QuoteControllerTest.java
Tests the quote controller
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
import za.ac.cput.domain.Quote;
import za.ac.cput.factory.QuoteFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuoteControllerTest {

private static Quote quote = QuoteFactory.createQuote("01/01/23", "01/03/23", 5000, true);

@Autowired
private TestRestTemplate restTemplate;

private final String baseUrl = "http://localhost:8080/quote";
    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Quote> postResponse = restTemplate.postForEntity(url, quote, Quote.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Quote savedQuote = postResponse.getBody();
        System.out.println("Saved data: " + savedQuote);
        assertEquals(quote.getQuoteNumber(), savedQuote.getQuoteNumber());


    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + quote.getQuoteNumber();
        System.out.println("URL: " + url);
        ResponseEntity<Quote> response = restTemplate.getForEntity(url, Quote.class);
        assertEquals(quote.getQuoteNumber(), response.getBody().getQuoteNumber());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Quote updated = new Quote.Builder().copy(quote).setTotalCost(25000).build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Quote> response = restTemplate.postForEntity(url, updated, Quote.class);
        assertNotNull(response.getBody());
    }

    @Disabled
    void e_delete() {
        String url = baseUrl + "/delete/" + quote.getQuoteNumber();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseUrl + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}
