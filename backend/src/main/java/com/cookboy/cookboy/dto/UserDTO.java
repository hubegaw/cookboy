package com.cookboy.cookboy.dto;

import com.cookboy.cookboy.recipe.Recipe;

import java.util.List;

public record UserDTO(
        Integer id,
        String name,
        String email,
        List<String> roles
) {

}
