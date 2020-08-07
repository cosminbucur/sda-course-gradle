package com.bucur.spring.mvc.hibernate.service;

import com.bucur.spring.mvc.hibernate.dao.UserDao;
import com.bucur.spring.mvc.hibernate.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserDao dao;

    public UserService() {
        super();
    }

    // API

    public void create(final User entity) {
        dao.create(entity);
    }

    public User findOne(final long id) {
        return dao.findOne(id);
    }

    public List<User> findAll() {
        return dao.findAll();
    }
}
