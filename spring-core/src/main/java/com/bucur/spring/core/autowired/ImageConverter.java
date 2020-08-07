package com.bucur.spring.core.autowired;

import org.springframework.stereotype.Component;

@Component
public class ImageConverter {

    public void convert() {
        System.out.println("converting...");
    }
}
