package com.cookboy.cookboy.recipe;

import com.cookboy.cookboy.dto.RecipeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS},
        allowedHeaders = {"*"})
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
    public ResponseEntity<Boolean> addRecipe(@RequestBody Recipe recipe, @RequestHeader("Authorization") String token) {
        service.addRecipe(recipe, token);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PutMapping
    public ResponseEntity<Boolean> updateRecipe(@RequestBody Recipe recipe) {
        service.updateRecipe(recipe);
        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRecipe(@PathVariable int id) {

        service.deleteRecipe(id);

        return ResponseEntity.status(HttpStatus.OK).body(true);
    }

}
