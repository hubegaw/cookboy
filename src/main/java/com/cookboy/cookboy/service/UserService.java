package com.cookboy.cookboy.service;

import com.cookboy.cookboy.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUser(String id);
    List<User> getAllUsers();
    User updateUser(String id, User user);
    void deleteUser(String id);
}
