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
import za.ac.cput.domain.Supplier;
import za.ac.cput.factory.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SupplierControllerTest {

    private static final Supplier supplier = SupplierFactory.createSupplier("ABC", "51653151", "abc@gmail.com", "51 cale street");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseUrl = "https://localhost:8080/supplier";
    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Supplier> postResponse = restTemplate.postForEntity(url, supplier, Supplier.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Supplier savedSupplier = postResponse.getBody();
        System.out.println("saved data: " + savedSupplier);
        assertEquals(supplier.getSupplierId(), savedSupplier.getSupplierId());
    }
    @Test
    void b_read() {
        String url = baseUrl + "/read/" + supplier.getSupplierId();
        System.out.println("url: " + url);
        ResponseEntity<Supplier> response = restTemplate.getForEntity(url, Supplier.class);
        assertEquals(supplier.getSupplierId(), response.getBody().getSupplierId());
        System.out.println(response.getBody());
    }
    @Test
    void c_update() {
        Supplier updated = new Supplier.Builder().copy(supplier).setCompanyName("XYZ").build();
        String url = baseUrl + "/update";
        System.out.println("Url: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Supplier>response = restTemplate.postForEntity(url, updated, Supplier.class);
        assertNotNull(response.getBody());

    }

    @Test
    void e_delete() {
        String url = baseUrl +"/delete/"+ supplier.getSupplierId();
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