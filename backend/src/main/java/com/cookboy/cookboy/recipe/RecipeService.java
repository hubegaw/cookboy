package com.cookboy.cookboy.recipe;

import com.cookboy.cookboy.config.JwtService;
import com.cookboy.cookboy.dto.RecipeDTO;
import com.cookboy.cookboy.dto.RecipeDTOMapper;
import com.cookboy.cookboy.user.User;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    private final RecipeDTOMapper recipeDTOMapper;
    private final JwtService jwtService;

    public List<RecipeDTO> getUserRecipes(int id) {
        return recipeRepository.findByUserId(id)
                .stream()
                .map(recipeDTOMapper)
                .collect(Collectors.toList());
    }

    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeDTOMapper)
                .collect(Collectors.toList());
    }

    public RecipeDTO getRecipe(int id) {
        return recipeRepository.findById(id)
                .stream()
                .map(recipeDTOMapper)
                .toList().get(0);
    }

    public Recipe addRecipe(Recipe recipe, String token) {
        String jwt = token.split(" ")[1].trim();
        int userId = jwtService.extractUserId(jwt);

        recipe.setUser(new User(userId));
        recipe.setCreated_at(Timestamp.from(Instant.now()));

        return recipeRepository.save(recipe);
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(int id) {
        recipeRepository.deleteById(id);
    }
}
