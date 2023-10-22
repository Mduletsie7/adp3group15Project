package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.Orders;
import za.ac.cput.factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.springframework.http.MediaType.APPLICATION_JSON;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@SpringBootTest
public class OrderControllerTest {
    private static Orders order = OrderFactory.createOrder("002", "001", "10/10/2023", "20/10/2023", "R5000");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/orders";

    @Test
    void create() {
        String url = baseUrl + "/create";
        ResponseEntity<Orders> postResponse = restTemplate.postForEntity(url, order, Orders.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Orders savedOrder = postResponse.getBody();
        System.out.println("Saved data: " + savedOrder);
        assertEquals(order.getOrderId(), savedOrder.getOrderId());
    }

    @Test
    void read() {
        String url = baseUrl + "/read/" + order.getOrderId();
        System.out.println("url: " + url);
        ResponseEntity<Orders> response = restTemplate.getForEntity(url, Orders.class);
        assertEquals(order.getOrderId(), response.getBody().getOrderId());
        System.out.println(response.getBody());
    }

    @Test
    void update() {
        Orders updated = new Orders.Builder().copy(order).setOrderId("005").build();
        String url = baseUrl + "/update";
        System.out.println("Url: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Orders>response = restTemplate.postForEntity(url, updated, Orders.class);
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {
        String url = baseUrl +"/delete/"+ order.getOrderId();
        System.out.println("Url: " + url);
        restTemplate.delete(url);
    }

    @Test
    void getAll() {
        String url = baseUrl + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}