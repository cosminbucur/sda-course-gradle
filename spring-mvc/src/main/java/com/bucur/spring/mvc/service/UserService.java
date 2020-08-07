package com.bucur.spring.mvc.service;

import com.bucur.spring.mvc.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    List<User> list();
}
