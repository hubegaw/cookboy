package com.cookboy.cookboy.recipe;

import com.cookboy.cookboy.dto.RecipeDTO;
import jakarta.servlet.http.HttpServletRequest;
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

    @GetMapping("/{userId}/recipes/{id}")
    public RecipeDTO getRecipeById(@PathVariable int id) {
        return service.getRecipe(id);
    }

    @GetMapping("/{userId}/recipes")
    public List<RecipeDTO> getRecipes(@PathVariable int userId) {
        return service.getRecipes(userId);
    }

    @PostMapping("/{userId}/recipes")
    public Recipe addRecipe(@RequestBody Recipe recipe) {
        return service.addRecipe(recipe);
    }

    @DeleteMapping("/{userId}/recipes/{recipeId}")
    public ResponseEntity<String> deleteRecipe(@PathVariable int recipeId, HttpServletRequest request) {

        service.deleteRecipe(recipeId);

        return ResponseEntity.status(HttpStatus.OK).body("Feedback deleted successfully");
    }

}
