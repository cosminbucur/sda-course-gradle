package com.bucur.spring.core.configs.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoBeanConfig {

    public static void main(String[] args) {
        ApplicationContext appContext =
                new AnnotationConfigApplicationContext(BeanConfig.class);

        MyBean myBean = appContext
                .getBean("myBean", MyBean.class);

        myBean.complexOperation();
    }
}
