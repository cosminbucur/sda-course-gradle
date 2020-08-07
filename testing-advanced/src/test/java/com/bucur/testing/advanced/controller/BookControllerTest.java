package com.bucur.testing.advanced.controller;

import com.bucur.testing.advanced.model.Book;
import com.bucur.testing.advanced.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringBootTest
public class BookControllerTest {

    @Autowired
    protected WebApplicationContext wac;
    @Autowired
    BookController bookController;
    @MockBean
    BookService bookService;
    private MockMvc mockMvc;
    private List<Book> books;

    @BeforeEach
    public void setUp() {
        this.mockMvc = standaloneSetup(this.bookController).build();
//        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        Book book1 = new Book();
        book1.setTitle("the brothers karamazov");
        book1.setAuthor("fyodor dostoevsky");
        book1.setPublished(LocalDate.of(1880, 1, 20));

        Book book2 = new Book();
        book2.setTitle("game of thrones");
        book2.setAuthor("george martin");
        book2.setPublished(LocalDate.of(2005, 6, 20));

        books = Arrays.asList(book1, book2);
    }

    @Test
    public void create() {
    }

    @Test
    public void findAll() {
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