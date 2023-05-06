package com.cookboy.cookboy.recipe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    List<Recipe> findByownerId(int id);
}
