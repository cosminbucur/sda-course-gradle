package com.bucur.spring.data.jpa.repository;

import com.bucur.spring.data.jpa.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<Person, Long> {

    Page<Person> findAllByAge(int age, Pageable pageable);
}
