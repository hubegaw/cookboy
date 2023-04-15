package com.cookboy.cookboy.service;

import com.cookboy.cookboy.entity.Recipe;

import java.util.Date;
import java.util.List;

public interface RecipeService {
    Recipe createRecipe(Recipe recipe);
    Recipe getRecipe(String id);
    List<Recipe> getAllRecipes();
    Recipe updateRecipe(String id, Recipe recipe);
    void deleteRecipe(String id);
    List<Recipe> getRecipesByOwnerId(String ownerId);
    List<Recipe> getRecipesByCreatedAt(Date createdAt);
    List<Recipe> getRecipesByTime(int time);
    List<Recipe> getRecipesByPortions(int portions);
}
