package com.interview.demo.service.impl;


import com.interview.demo.dao.UserDao;
import com.interview.demo.model.User;
import com.interview.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Optional<User> getUserByUserName(String username) {
      return userDao.findById(username);
    }

    @Override
    public Boolean addUser(User user) {
        if(getUserByUserName(user.getUserName()).isPresent()){
            return false;
        }
        userDao.insert(user);
        return true;
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(String id) {
        return null;
    }
}
