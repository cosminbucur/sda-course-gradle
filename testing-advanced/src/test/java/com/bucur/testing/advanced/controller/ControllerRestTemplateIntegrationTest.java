package com.bucur.testing.advanced.controller;

import com.bucur.testing.advanced.dto.BookRequest;
import com.bucur.testing.advanced.dto.BookResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerRestTemplateIntegrationTest {

    @LocalServerPort
    private static int port;
    private static final String API_BOOKS = "http://localhost:" + port + "/api";

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void create() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("the brothers karamazov");
        bookRequest.setAuthor("fyodor dostoevsky");
        bookRequest.setPublished(LocalDate.of(1880, 1, 20));

        restTemplate.postForObject(API_BOOKS + "/books",
                bookRequest,
                ResponseEntity.class);
    }

    @Test
    public void findAll() throws Exception {
        ResponseEntity<BookResponse[]> response = restTemplate.getForEntity(
                API_BOOKS + "/books", BookResponse[].class);
        assertThat(response.getBody()).isNotEmpty();
    }

    @Test
    public void findById() {
        ResponseEntity<BookResponse> response = restTemplate
                .getForObject(
                        API_BOOKS + "/1", ResponseEntity.class
                );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    public void getBooksByAuthor() {
    }

    @Test
    public void update() {
    }

    @Test
    public void partialUpdate() {
    }

    @Test
    public void delete() {
    }
}