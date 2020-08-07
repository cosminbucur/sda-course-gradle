package com.bucur.spring.data.jpa.repository;

import com.bucur.spring.data.jpa.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PersonCrudRepositoryIntegrationTest {

    @Autowired
    public PersonCrudRepository personCrudRepository;

    @Test
    public void givenPerson_whenFindByName_thenReturnPerson() {
        Person expected = new Person("andreea", 12);
        personCrudRepository.save(expected);

        Person actual = personCrudRepository.findByName("andreea")
                .orElse(null);

        assertThat(actual).isEqualTo(expected);
    }
}