package com.bucur.testing.advanced.service;

import com.bucur.testing.advanced.dto.BookRequest;
import com.bucur.testing.advanced.dto.BookResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookServiceIntegrationTest {

    @Autowired
    private BookService bookService;

    @Test
    public void save() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("the brothers karamazov");
        bookRequest.setAuthor("fyodor dostoevsky");
        bookRequest.setPublished(LocalDate.of(1880, 1, 20));

        BookResponse expected = new BookResponse();
        expected.setId(1L);
        expected.setTitle("the brothers karamazov");
        expected.setAuthor("fyodor dostoevsky");
        expected.setPublished(LocalDate.of(1880, 1, 20));

        BookResponse actual = bookService.save(bookRequest);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void givenExistingBookRequest_whenSave_thenThrowException() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("the brothers karamazov");
        bookRequest.setAuthor("fyodor dostoevsky");
        bookRequest.setPublished(LocalDate.of(1880, 1, 20));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> bookService.save(bookRequest));
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void findByAuthor() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void partialUpdate() {
    }
}
