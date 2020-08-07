package com.bucur.spring.core.configs.scan;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    public void complexOperation() {
        System.out.println("--- in complex operation");
    }
}
