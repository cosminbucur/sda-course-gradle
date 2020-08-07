package com.bucur.spring.core.configs.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoScanConfig {

    public static void main(String[] args) {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(ScanConfig.class);

        MyComponent myComponent = appContext
                .getBean("myComponent", MyComponent.class);

        myComponent.complexOperation();
    }
}
