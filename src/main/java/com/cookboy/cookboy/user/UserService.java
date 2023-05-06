package com.cookboy.cookboy.user;

import com.cookboy.cookboy.dto.RecipeDTO;
import com.cookboy.cookboy.dto.RecipeDTOMapper;
import com.cookboy.cookboy.dto.UserDTO;
import com.cookboy.cookboy.dto.UserDTOMapper;
import com.cookboy.cookboy.recipe.Recipe;
import com.cookboy.cookboy.recipe.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;
    private final RecipeRepository recipeRepository;
    private final RecipeDTOMapper recipeDTOMapper;

    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userDTOMapper)
                .collect(Collectors.toList());
    }

    public UserDTO getUser(int id) {
        return userRepository.findById(id)
                .stream()
                .map(userDTOMapper)
                .toList().get(0);
    }

    public List<RecipeDTO> getRecipes(int id) {
        return recipeRepository.findByownerId(id)
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

}
