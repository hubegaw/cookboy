package com.cookboy.cookboy.recipe;

import com.cookboy.cookboy.dto.RecipeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService service;

    @GetMapping("/{id}")
    public RecipeDTO getRecipeById(@PathVariable int id) {
        return service.getRecipe(id);
    }

    @GetMapping("/user/{userId}")
    public List<RecipeDTO> getUserRecipes(@PathVariable int userId) {
        return service.getUserRecipes(userId);
    }

    @GetMapping
    public List<RecipeDTO> getAllRecipes() {
        return service.getAllRecipes();
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return service.addRecipe(recipe);
    }

    @PutMapping
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        return service.addRecipe(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecipe(@PathVariable int id) {

        service.deleteRecipe(id);

        return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");
    }

}
