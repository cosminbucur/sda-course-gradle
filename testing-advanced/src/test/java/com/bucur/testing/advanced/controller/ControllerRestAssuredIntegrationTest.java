package com.bucur.testing.advanced.controller;

import com.bucur.testing.advanced.SpringTestingApplication;
import com.bucur.testing.advanced.config.H2TestProfileJPAConfig;
import com.bucur.testing.advanced.dto.BookRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;

@ActiveProfiles("test")
//@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest(
//    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = {SpringTestingApplication.class, H2TestProfileJPAConfig.class}
)
public class ControllerRestAssuredIntegrationTest {

    @LocalServerPort
    private static int port = 8083;

    private static final String API_BOOKS = "http://localhost:" + port + "/api";

    @BeforeEach
    public void setUp() {
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

    // see json path
    @Test
    public void findAll() throws Exception {
        given()
                .when()
                .get(API_BOOKS + "/books")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].title", equalTo("Game of thrones"));
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