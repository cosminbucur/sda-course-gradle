# Group X

## Project structure
The project contains multiple sub modules, each with a similar structure:

        course name (ex: java-advanced)
            scr.main.java.com.bucur (packages)
                topic (ex: collections)
                    subtopic (ex: map)
                        ex1 (proposed exercise)
                        slide1 (code from the first slide)
                        how (practical use of a topic)

---

## Courses

### fundamentals

- methods
- static

---

### testing
- junit4
- mockito

---

### java-advanced
- oop

    - inheritance
    - encapsulation
    - abstraction
    - interfaces
    - enums

- exceptions

- collections

    - generics
    - list
    - set
    - map

- io
    
    - buffered
    - io stream
    - nio
        - files

- functional
    
    - lambda

---

### design patterns

- cohesion
- coupling
- fluent

##### GRASP
- controller
- expert
- creator

##### SOLID
- single responsibility
- open closed
- liskov
- interface segregation
- dependency inversion

---

### java-advanced-code

- oop

    - inheritance
    - encapsulation
    - abstraction
    - interfaces
    - enums

- exceptions

- collections

    - generics
    - stack
    - list
    - set
    - map
    - queue

- functional

    - interfaces  
    - lambda
    - stream

- i/o

    - io
    - nio
    - properties, yml
    - logger
    
- concurrent

    - thread
    - executor
    - callable
    - synchronization

---

##  databases

### sql
- mysql
- mysql workbench
- data definition language
- data manipulation language
- data query language
- aggregate functions
- views
- stored procedures
- functions
- triggers

### no sql
- mongo
- robo t3
- mongo crud

## JDBC

- statements
- prepared statements
- transactions

---

## hibernate

- config
- crud
- associations
    - one-to-one
    - one-to-many unidirectional
    - one-to-many unidirectional join
    - one-to-many bidirectional
    - many-to-many
- states
- transactions
- types
- queries
    - hql
    - native
- session
- audit 

---

### spring

##### Spring Core
- config
- beans
- scope
- @Autowired
- @Qualifier

##### Spring Boot 2
- command line runner
- auto config

##### Spring Data JPA
- domain architecture
- layered architecture
- repository
    - crud repository
    - paging and sorting repository
    - jpa repository
- validation
- repository pattern

##### Spring MVC JSP
- persistence jpa config

    - data source
    - entity manager
    - transaction manager
    
- web mvc config
    - view resolver
    - validator
    
- service (business layer)
- controller
    
    - @RequestMapping
    - @PathVariable
    - @RequestParam
   
- mvc
    
    - model
    - model map
    - model and view
    - BindingResult
    - @ModelAttribute
     
    - redirect
    
    - forms
    - form validation

##### Spring Thymeleaf
- thymeleaf tags
- thymeleaf templates

##### Spring Security

##### Spring REST

##### Angular Integration

---

### testing-advanced
- multiple database spring config
- spring profiles (dev + test)
- unit tests (junit 5)
    - mapper test
- mocks (mockito)
    - service test
    - controller test
- integration tests
    - service test
    - controller test

---

## How to get it on your computer

##### in browser

	go to github repo at https://github.com/cosminbucur/sda-course-sample

	copy clone command

##### on computer
	go to C:\dev

	right click > git bash (or terminal)

##### in terminal
	> git clone https://github.com/cosminbucur/sda-course-sample.git

##### in intellij
	open project C:\dev\sda-course-sample

	check auto import and wait

	update project
