/**
 * ProjectControllerTest.java
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
import za.ac.cput.domain.Project;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.factory.ProjectFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectControllerTest {
    private static Project project = ProjectFactory.createProject("Saranto", "28 August 2023", "25 Dec 2023", "R150000", "Active");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseUrl = "http://localhost:8080/project";
    @Test
    void a_create() {
        String url = baseUrl + "/create";
        ResponseEntity<Project> postResponse = restTemplate.postForEntity(url, project, Project.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        Project savedProject = postResponse.getBody();
        System.out.println("Saved data: " + savedProject);
        assertEquals(project.getProjectId(), savedProject.getProjectId());


    }

    @Test
    void b_read() {
        String url = baseUrl + "/read/" + project.getProjectId();
        System.out.println("URL: " + url);
        ResponseEntity<Project> response = restTemplate.getForEntity(url, Project.class);
        assertEquals(project.getProjectId(), response.getBody().getProjectId());
        System.out.println(response.getBody());
    }

    @Test
    void c_update() {
        Project updated = new Project.Builder().copy(project).setProjectName("Maximus").build();
        String url = baseUrl + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Project> response = restTemplate.postForEntity(url, updated, Project.class);
        assertNotNull(response.getBody());
    }

    @Disabled
    void e_delete() {
        String url = baseUrl + "/delete/" + project.getProjectId();
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