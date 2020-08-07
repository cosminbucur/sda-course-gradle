package com.bucur.spring.mvc.service;

import com.bucur.spring.mvc.dao.UserDao;
import com.bucur.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> list() {
        return userDao.list();
    }
}
