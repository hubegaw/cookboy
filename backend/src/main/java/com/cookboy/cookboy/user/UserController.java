package com.cookboy.cookboy.user;

import com.cookboy.cookboy.dto.RecipeDTO;
import com.cookboy.cookboy.dto.UserDTO;
import com.cookboy.cookboy.recipe.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(service.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(service.getUser(id));
    }

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
}
