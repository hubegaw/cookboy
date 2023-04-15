package com.cookboy.cookboy.service;

import com.cookboy.cookboy.dao.UserDAO;
import com.cookboy.cookboy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public User createUser(User user) {
        return userDAO.save(user);
    }

    public User getUser(String id) {
        return userDAO.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public User updateUser(String id, User user) {
        user.setId(id);
        return userDAO.save(user);
    }

    public void deleteUser(String id) {
        userDAO.deleteById(id);
    }
}
