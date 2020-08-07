package com.bucur.testing.advanced.service;

import com.bucur.testing.advanced.dto.BookMapper;
import com.bucur.testing.advanced.dto.BookRequest;
import com.bucur.testing.advanced.dto.BookResponse;
import com.bucur.testing.advanced.model.Book;
import com.bucur.testing.advanced.repository.BookRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = { SpringTestConfiguration.class })
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private BookMapper bookMapper;

    @Mock
    private ObjectMapper jacksonObjectMapper;

    @InjectMocks
    private BookService bookService;

    @Test
    public void save() {
        BookRequest bookRequest = new BookRequest();
        bookRequest.setTitle("the brothers karamazov");
        bookRequest.setAuthor("fyodor dostoevsky");
        bookRequest.setPublished(LocalDate.of(1880, 1, 20));

        Book mockBook = new Book();
        mockBook.setId(1L);
        mockBook.setTitle("the brothers karamazov");
        mockBook.setAuthor("fyodor dostoevsky");
        mockBook.setPublished(LocalDate.of(1880, 1, 20));

        BookResponse mockResponse = new BookResponse();
        mockBook.setId(1L);
        mockBook.setTitle("the brothers karamazov");
        mockBook.setAuthor("fyodor dostoevsky");
        mockBook.setPublished(LocalDate.of(1880, 1, 20));

        when(bookRepository.findByTitle(anyString()))
                .thenReturn(null);
        when(bookRepository.findByTitle(anyString()))
                .thenReturn(mockBook);
        when(bookMapper.toDto(any(Book.class)))
                .thenReturn(mockResponse);

        BookResponse actual = bookService.save(bookRequest);

        assertThat(actual).isEqualTo(mockResponse);
    }

    @Test
    public void givenExistingBookRequest_whenSave_thenThrowException() {
        BookRequest bookRequest = new BookRequest();

        bookRequest.setTitle("the brothers karamazov");
        bookRequest.setAuthor("fyodor dostoevsky");
        bookRequest.setPublished(LocalDate.of(1880, 1, 20));

        Book mockBook = new Book();
        mockBook.setId(1L);
        mockBook.setTitle("the brothers karamazov");
        mockBook.setAuthor("fyodor dostoevsky");
        mockBook.setPublished(LocalDate.of(1880, 1, 20));

        when(bookRepository.findByTitle(anyString()))
                .thenReturn(mockBook);

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