package com.bucur.spring.data.jpa.config;

import com.bucur.spring.data.jpa.association.Father;
import com.bucur.spring.data.jpa.association.FatherRepository;
import com.bucur.spring.data.jpa.association.Son;
import com.bucur.spring.data.jpa.association.SonRepository;
import com.bucur.spring.data.jpa.book.Book;
import com.bucur.spring.data.jpa.book.BookRepository;
import com.bucur.spring.data.jpa.exception.NotFoundException;
import com.sda.spring.data.jpa.validation.User;
import com.sda.spring.data.jpa.validation.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Optional;

@Configuration
public class AppConfig {

    private static final Logger log = LoggerFactory.getLogger(AppConfig.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private FatherRepository fatherRepository;

    @Autowired
    private SonRepository sonRepository;

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            log.debug("in command line runner...");

            Book book = createBook();
            bookRepository.save(book);

            findBookUsingOptionalGet();

            findBookUsingOptionalOrElseThrow();

            testAssociations();

            testValidation();
        };
    }

    private void testValidation() {
        User user = createBadUser();
        User newUser = userRepository.save(user);
        User savedUser = userRepository.findById(newUser.getId())
                .orElseThrow(() -> new NotFoundException("user not found"));
        log.info("saved user: {}", savedUser);
    }

    private User createUser() {
        User user = new User();
        user.setName("jon snow");
        user.setEmail("jonsnow@gmail.com");
        user.setAge(30);
        user.setConsent(true);
        user.setAboutMe("I'm a watcher on the wall");
        return user;
    }

    private User createBadUser() {
        User user = new User();
        user.setName("");
        user.setEmail("jonsnowgmail.com");
        user.setAge(5);
        user.setConsent(false);
        user.setAboutMe("....");
        return user;
    }

    private void testAssociations() {
        Son son1 = new Son();
        son1.setName("son1");

        Son son2 = new Son();
        son2.setName("son2");

        Father father = new Father();
        father.setName("father");

        father.getSons().add(son1);
        father.getSons().add(son2);

        fatherRepository.save(father);
        log.info("father repository size: {}", fatherRepository.count());
        log.info("son repository size: {}", sonRepository.count());
    }

    private void findBookUsingOptionalGet() {
        Optional<Book> savedBookOptional =
                bookRepository.findById(1L);
        Book savedBook = null;
        if (savedBookOptional.isPresent()) {
            savedBook = savedBookOptional.get();
        }

        log.debug("saved book: {}", savedBook);
    }

    private void findBookUsingOptionalOrElseThrow() {
        Book savedBook = bookRepository.findById(1L).orElseThrow(
                () -> new RuntimeException("book not found"));

        log.debug("saved book: {}", savedBook);
    }

    private Book createBook() {
        Book book = new Book();
        book.setTitle("Game of thrones");
        book.setAuthor("George Martin");
        book.setPublished(LocalDate.now());
        return book;
    }
}
