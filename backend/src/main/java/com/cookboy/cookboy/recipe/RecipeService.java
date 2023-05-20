package com.cookboy.cookboy.recipe;

import com.cookboy.cookboy.dto.RecipeDTO;
import com.cookboy.cookboy.dto.RecipeDTOMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;

    private final RecipeDTOMapper recipeDTOMapper;

    public List<RecipeDTO> getRecipes(int id) {
        return recipeRepository.findByUserId(id)
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

    public Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(int id) {
        recipeRepository.deleteById(id);
    }
}
