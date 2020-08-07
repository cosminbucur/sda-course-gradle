package com.bucur.spring.core.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

// https://howtodoinjava.com/spring-core/spring-resource-loader-aware/
public class DemoResourceLoader {

    @Autowired
    private static ResourceLoader resourceLoader;

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ResourceLoaderConfig.class);

        /// load resource using application context
        Resource resourceFromContext = context.getResource("file:data.txt");

        // load resource from file
        Resource resourceFromFile = resourceLoader.getResource("file:classpathdata.txt");


        // load resource from class path
        Resource resourceFromClassPath = resourceLoader.getResource("classpath:classpathdata.txt");

        Resource localResource = resourceLoader.getResource("data.txt");

        System.out.println(resourceFromContext.contentLength());
        System.out.println(localResource.contentLength());
    }
}
