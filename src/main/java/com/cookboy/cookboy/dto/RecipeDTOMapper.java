package com.cookboy.cookboy.dto;

import com.cookboy.cookboy.recipe.Recipe;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class RecipeDTOMapper implements Function<Recipe,RecipeDTO> {
    @Override
    public RecipeDTO apply(Recipe recipe) {
        return new RecipeDTO(
                recipe.getId(),
                recipe.getTitle(),
                recipe.getDescription(),
                recipe.getTime(),
                recipe.getPortions(),
                recipe.getCreated_at()
        );
    }
}
