package com.bucur.spring.data.jpa.repository;

import com.bucur.spring.data.jpa.domain.Person;
import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<Person, Long> {

}
