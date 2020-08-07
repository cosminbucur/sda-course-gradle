package com.bucur.spring.mvc.hibernate.dao;

import com.bucur.spring.mvc.hibernate.model.User;

import java.util.List;

public interface UserDao {

    User findOne(long id);

    List<User> findAll();

    void create(User entity);

    User update(User entity);

    void delete(User entity);

    void deleteById(long entityId);
}
