package com.bucur.spring.mvc.dao;

import com.bucur.spring.mvc.model.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    List<User> list();
}
