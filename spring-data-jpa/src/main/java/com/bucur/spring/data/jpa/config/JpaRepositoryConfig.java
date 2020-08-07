package com.bucur.spring.data.jpa.config;

import com.bucur.spring.data.jpa.domain.Person;
import com.sda.spring.data.jpa.repository.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Configuration
public class JpaRepositoryConfig {

    private static final Logger log = LoggerFactory.getLogger(JpaRepositoryConfig.class);

    @Autowired
    public PersonJpaRepository personJpaRepository;

    @Bean
    public CommandLineRunner jpaData() {
        return args -> {
            loadData();

            long idOfFirstPerson = personJpaRepository.findAll().get(0).getId();

            log.info("--- finding one person");
//            Person existingPerson = personJpaRepository.getOne(idOfFirstPerson);
//            log.info("existing person: {}", existingPerson);

            Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
            Iterable<Person> firstTwoPersons = personJpaRepository.findAll(firstPageWithTwoElements);

            personJpaRepository.deleteInBatch(firstTwoPersons);

            personJpaRepository.deleteAllInBatch();
        };
    }

    private void loadData() {
        personJpaRepository.save(new Person("paul", 32));
        personJpaRepository.save(new Person("alina", 28));
        personJpaRepository.save(new Person("kazimir", 34));
        personJpaRepository.save(new Person("lidia", 32));
        personJpaRepository.save(new Person("violeta", 32));
    }
}
