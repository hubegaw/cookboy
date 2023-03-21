package com.cookboy.cookboy.dao;

import com.cookboy.cookboy.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private EntityManager entityManager;

    @Autowired
    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {

        TypedQuery<User> query = entityManager.createQuery("from User", User.class);

        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public User findById(int user_id) {

        User user = entityManager.find(User.class, user_id);

        return user;
    }

    @Override
    public User save(User user) {

        User newUser = entityManager.merge(user);

        return newUser;
    }

    @Override
    public void deleteById(int user_id) {

        User user = entityManager.find(User.class, user_id);

        entityManager.remove(user);
    }
}