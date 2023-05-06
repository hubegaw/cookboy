package com.cookboy.cookboy.dto;

import java.sql.Timestamp;

public record RecipeDTO (
    Integer id,
    String title,
    String description,
    Integer time,
    Integer portions,
    Timestamp created_at
) { }
