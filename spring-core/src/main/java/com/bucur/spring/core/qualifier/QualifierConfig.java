package com.bucur.spring.core.qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QualifierConfig {

    @Bean
    public BarFormatter barFormatter() {
        return new BarFormatter();
    }

    @Bean
    public FooFormatter fooFormatter() {
        return new FooFormatter();
    }

    @Bean
    public FooService fooService() {
        return new FooService();
    }
}