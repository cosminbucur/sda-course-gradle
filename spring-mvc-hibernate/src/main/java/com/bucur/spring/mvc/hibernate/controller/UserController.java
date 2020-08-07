package com.bucur.spring.mvc.hibernate.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

//    @GetMapping("/")
//    public String index() {
//        return "index";
//    }

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String home() {

        return "This is home page";
    }
}
