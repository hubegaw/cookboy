package com.cookboy.cookboy.dao;

import com.cookboy.cookboy.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserDAO extends MongoRepository<User, String> {

}