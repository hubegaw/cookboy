package com.cookboy.cookboy.dao;

import com.cookboy.cookboy.entity.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface RecipeDAO extends MongoRepository<Recipe, String> {
    List<Recipe> findByOwnerId(String ownerId);
    List<Recipe> findByCreatedAt(Date createdAt);
    List<Recipe> findByTime(int time);

    List<Recipe> findByPortions(int portions);
}
