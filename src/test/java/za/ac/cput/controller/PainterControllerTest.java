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
import za.ac.cput.domain.Painter;
import za.ac.cput.factory.PainterFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PainterControllerTest {

private static Painter painter = PainterFactory.createPainter("Mdu Kelvin", "Letsie", "0676808676", "mdu.letsie7@gmail.com", "7 De Grendel Road", "Cape Town", "WC", "7441");

@Autowired
private TestRestTemplate restTemplate;

private final String baseUrl = "http://localhost:8080/painter";
    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Painter> postResponse = restTemplate.postForEntity(url, painter, Painter.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Painter savedPainter = postResponse.getBody();
        System.out.println("Saved data: " + savedPainter);
        assertEquals(painter.getPainterId(), savedPainter.getPainterId());


    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + painter.getPainterId();
        System.out.println("URL: " + url);
        ResponseEntity<Painter> response = restTemplate.getForEntity(url, Painter.class);
        assertEquals(painter.getPainterId(), response.getBody().getPainterId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Painter updated = new Painter.Builder().copy(painter).setFirstName("Temuso").build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Painter> response = restTemplate.postForEntity(url, updated, Painter.class);
        assertNotNull(response.getBody());
    }

    @Disabled
    void e_delete() {
        String url = baseUrl + "/delete/" + painter.getPainterId();
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