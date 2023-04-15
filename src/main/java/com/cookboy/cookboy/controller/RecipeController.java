package com.cookboy.cookboy.controller;

import com.cookboy.cookboy.entity.Recipe;
import com.cookboy.cookboy.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private String NO_DATA_FOUND = "No recipes found!";

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/recipes")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.createRecipe(recipe);
    }

    @GetMapping("/{id}")
    public Recipe getRecipe(@PathVariable String id) {
        return recipeService.getRecipe(id);
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@PathVariable String id, @RequestBody Recipe recipe) {
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable String id) {
        recipeService.deleteRecipe(id);
    }

    @GetMapping(params = "ownerId")
    public List<Recipe> getRecipesByOwnerId(@RequestParam String id) {
        List<Recipe> retrievedRecipes = recipeService.getRecipesByOwnerId(id);

        return retrievedRecipes;
    }

    @GetMapping(params = "createdAt")
    public List<Recipe> getRecipesByCreatedAt(@RequestParam Date createdAt) {
        return recipeService.getRecipesByCreatedAt(createdAt);
    }

    @GetMapping(params = "time")
    public List<Recipe> getRecipesByTime(@RequestParam int time) {
        return recipeService.getRecipesByTime(time);
    }

    @GetMapping(params = "portions")
    public List<Recipe> getRecipesBPortions(@RequestParam int portions) {
        return recipeService.getRecipesByPortions(portions);
    }
}
