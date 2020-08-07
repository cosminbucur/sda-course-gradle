package com.bucur.spring.core.autowired;

import org.springframework.stereotype.Component;

@Component
public class SpellChecker {

    public SpellChecker() {
        System.out.println("spellchecker constructor");
    }

    public void checkSpelling() {
        System.out.println("check spelling...");
    }
}
