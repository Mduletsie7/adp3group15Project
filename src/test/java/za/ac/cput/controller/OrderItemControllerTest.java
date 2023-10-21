package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.domain.OrderItem;
import za.ac.cput.factory.OrderItemFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderItemControllerTest {

    private static OrderItem orderItem = OrderItemFactory.createOrderItem("001", "001", "Brushes", "250", "4");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "https://localhost:8080/orderItem";
    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<OrderItem> postResponse = restTemplate.postForEntity(url, orderItem, OrderItem.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        OrderItem savedOrderItem = postResponse.getBody();
        System.out.println("Saved data: " + savedOrderItem);
        assertEquals(orderItem.getOrderItemId(), savedOrderItem.getOrderItemId());
    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + orderItem.getOrderItemId();
        System.out.println("Url: " + url);
        ResponseEntity<OrderItem> response = restTemplate.getForEntity(url, OrderItem.class);
        assertEquals(orderItem.getOrderItemId(), response.getBody().getOrderItemId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        OrderItem updated = new OrderItem.Builder().copy(orderItem).setOrderItemId("005").build();
        String url = baseUrl + "/update";
        System.out.println("Url: " + url);
        System.out.println("post data: " + updated);
        ResponseEntity<OrderItem> response = restTemplate.postForEntity(url, updated, OrderItem.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseUrl + "/delete/" + orderItem.getOrderItemId();
        System.out.println("Url: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseUrl + "/getAll";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}