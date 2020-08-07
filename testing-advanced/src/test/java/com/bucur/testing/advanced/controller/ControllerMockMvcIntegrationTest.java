package com.bucur.testing.advanced.controller;

import com.bucur.testing.advanced.SpringTestingApplication;
import com.bucur.testing.advanced.config.H2TestProfileJPAConfig;
import com.bucur.testing.advanced.dto.BookRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;


@ActiveProfiles("test")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {SpringTestingApplication.class, H2TestProfileJPAConfig.class}
)
public class ControllerMockMvcIntegrationTest {

    @LocalServerPort
    private static int port;
    private static final String API_BOOKS = "http://localhost:" + port + "/api";
    @Autowired
    private MockMvc mockMvc;
    private JacksonTester<BookRequest> jsonBookRequest;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        RestAssured.baseURI = "http://localhost:" + port + "/api";
        RestAssured.port = port;
    }

    @Test
    public void create() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("the brothers karamazov");
        bookRequest.setAuthor("fyodor dostoevsky");
        bookRequest.setPublished(LocalDate.of(1880, 1, 20));

        with()
                .body(bookRequest)
                .when()
                .request("POST", API_BOOKS + "/books")
                .then()
                .statusCode(201);
    }

    @Test
    public void findAll() throws Exception {
        given()
                .when()
                .get(API_BOOKS + "/books")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .contentType(ContentType.JSON);
    }

    @Test
    public void findById() {

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