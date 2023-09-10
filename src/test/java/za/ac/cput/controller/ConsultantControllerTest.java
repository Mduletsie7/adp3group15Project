/**
 * ConsultantControllerTest.java
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
import za.ac.cput.domain.Consultant;
import za.ac.cput.domain.Painter;
import za.ac.cput.factory.ConsultantFactory;
import za.ac.cput.factory.PainterFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConsultantControllerTest {

    private static Consultant consultant = ConsultantFactory.createConsultant("Lerato", "Moshabi", "22 Mrabaraba Street", "lg@gmai.com", "0817666452");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8080/consultant";
    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Consultant> postResponse = restTemplate.postForEntity(url, consultant, Consultant.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Consultant savedConsultant = postResponse.getBody();
        System.out.println("Saved data: " + savedConsultant);
        assertEquals(consultant.getConsultantId(), savedConsultant.getConsultantId());


    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + consultant.getConsultantId();
        System.out.println("URL: " + url);
        ResponseEntity<Consultant> response = restTemplate.getForEntity(url, Consultant.class);
        assertEquals(consultant.getConsultantId(), response.getBody().getConsultantId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Consultant updated = new Consultant.Builder().copy(consultant).setFirstName("Flash").build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Consultant> response = restTemplate.postForEntity(url, updated, Consultant.class);
        assertNotNull(response.getBody());
    }

    @Disabled
    void e_delete() {
        String url = baseUrl + "/delete/" + consultant.getConsultantId();
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