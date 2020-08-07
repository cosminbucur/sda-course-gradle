package com.bucur.spring.core.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class FooService {

    @Autowired
    @Qualifier("fooFormatter")
    private Formatter formatter;

    public void run() {
        formatter.format();
    }
}
