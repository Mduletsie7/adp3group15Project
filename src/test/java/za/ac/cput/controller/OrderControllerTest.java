package za.ac.cput.controller;

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
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderControllerTest {
    private static final Order order = OrderFactory.createOrder("001", "001", "10/10/2023", "20/10/2023", "R5000");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "https://localhost:8080/order";
    @Test
    void create() {
        String url = baseUrl + "/create";
        ResponseEntity<Order> postResponse = restTemplate.postForEntity(url, order, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Order savedOrder = postResponse.getBody();
        System.out.println("Saved data: " + savedOrder);
        assertEquals(order.getOrderId(), savedOrder.getOrderId());
    }

    @Test
    void read() {
        String url = baseUrl + "/read/" + order.getOrderId();
        System.out.println("url: " + url);
        ResponseEntity<Order> response = restTemplate.getForEntity(url, Order.class);
        assertEquals(order.getOrderId(), response.getBody().getOrderId());
        System.out.println(response.getBody());
    }

    @Test
    void update() {
        Order updated = new Order.Builder().copy(order).setOrderId("005").build();
        String url = baseUrl + "/update";
        System.out.println("Url: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Order>response = restTemplate.postForEntity(url, updated, Order.class);
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