package com.bucur.testing.advanced.dto;

import com.bucur.testing.advanced.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class BookMapperTest {

    BookMapper bookMapper;

    @BeforeEach
    void setUp() {
        bookMapper = new BookMapper();
    }

    @Test
    void toDto() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("game of thrones");
        book.setAuthor("george martin");
        book.setPublished(LocalDate.of(2005, 6, 30));

        BookResponse expected = new BookResponse();
        expected.setId(1L);
        expected.setTitle("game of thrones");
        expected.setAuthor("george martin");
        expected.setPublished(LocalDate.of(2005, 6, 30));

        BookResponse actual = bookMapper.toDto(book);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void toEntity() {
    }
}