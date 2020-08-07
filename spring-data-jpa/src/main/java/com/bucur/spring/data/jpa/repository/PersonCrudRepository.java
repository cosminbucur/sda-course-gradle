package com.bucur.spring.data.jpa.repository;

import com.bucur.spring.data.jpa.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonCrudRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByName(String name);
}
