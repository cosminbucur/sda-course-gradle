package com.bucur.spring.boot.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

// https://htr3n.github.io/2018/12/jsp-spring-boot/
// https://www.boraji.com/spring-boot-creating-web-application-using-spring-mvc
// https://hellokoding.com/spring-boot-hello-world-example-with-jsp/
// https://www.baeldung.com/maven-webjars
// used to create a deployable war
@SpringBootApplication
public class SpringBootJspApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJspApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootJspApplication.class);
    }
}
