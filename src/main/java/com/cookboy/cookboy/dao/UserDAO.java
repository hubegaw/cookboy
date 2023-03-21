package com.cookboy.cookboy.dao;

import com.cookboy.cookboy.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> findAll();

    User findById(int user_id);

    User save(User user);

    void deleteById(int user_id);
}