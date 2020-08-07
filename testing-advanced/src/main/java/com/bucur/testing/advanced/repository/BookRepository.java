package com.bucur.testing.advanced.repository;

import com.bucur.testing.advanced.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthor(String author);

    Book findByTitle(String title);
}
