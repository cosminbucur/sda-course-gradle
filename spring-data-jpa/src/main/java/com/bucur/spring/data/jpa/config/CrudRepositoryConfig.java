package com.bucur.spring.data.jpa.config;

import com.bucur.spring.data.jpa.domain.Person;
import com.bucur.spring.data.jpa.exception.NotFoundException;
import com.bucur.spring.data.jpa.repository.PersonCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrudRepositoryConfig {

    private static final Logger log = LoggerFactory.getLogger(CrudRepositoryConfig.class);

    @Autowired
    public PersonCrudRepository personCrudRepository;

    @Bean
    public CommandLineRunner crudData() {
        return args -> {
            // create
            personCrudRepository.save(new Person("ana", 25));
            personCrudRepository.save(new Person("paul", 30));

            // read
            Person paul = personCrudRepository.findByName("paul")
                    .orElseThrow(() -> new NotFoundException("user not found"));

            Iterable<Person> people = personCrudRepository.findAll();
            people.forEach(person -> log.info("person: {}", person));

            boolean existsById = personCrudRepository.existsById(paul.getId());
            log.info("paul exists by id: {}", existsById);

            // update
            paul.setAge(35);
            personCrudRepository.save(paul);

            long count = personCrudRepository.count();
            log.info("count before delete: {}", count);

            // delete
            personCrudRepository.deleteById(paul.getId());

            personCrudRepository.deleteAll();

            customFind();
        };
    }

    private void customFind() {
        log.info("--- in custom find");
        personCrudRepository.save(new Person("alex", 20));

        Person person = personCrudRepository.findByName("alex")
                .orElseThrow(() -> new NotFoundException("user not found"));
        log.info("find person by name 'alex': {}", person);
    }
}
