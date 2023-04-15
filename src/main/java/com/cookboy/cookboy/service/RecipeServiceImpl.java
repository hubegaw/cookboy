package com.cookboy.cookboy.service;

import com.cookboy.cookboy.dao.RecipeDAO;
import com.cookboy.cookboy.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeDAO recipeDAO;

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeDAO.save(recipe);
    }

    @Override
    public Recipe getRecipe(String id) {
        return recipeDAO.findById(id).orElse(null);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeDAO.findAll();
    }

    @Override
    public Recipe updateRecipe(String id, Recipe recipe) {
        recipe.setId(id);
        return recipeDAO.save(recipe);
    }

    @Override
    public void deleteRecipe(String id) {
        recipeDAO.deleteById(id);
    }

    @Override
    public List<Recipe> getRecipesByOwnerId(String ownerId) {
        System.out.println(recipeDAO.findByOwnerId(ownerId));
        return recipeDAO.findByOwnerId(ownerId);
    }

    @Override
    public List<Recipe> getRecipesByCreatedAt(Date createdAt) {
        return recipeDAO.findByCreatedAt(createdAt);
    }

    @Override
    public List<Recipe> getRecipesByTime(int time) {
        return recipeDAO.findByTime(time);
    }

    @Override
    public List<Recipe> getRecipesByPortions(int portions) {
        return recipeDAO.findByPortions(portions);
    }

}
