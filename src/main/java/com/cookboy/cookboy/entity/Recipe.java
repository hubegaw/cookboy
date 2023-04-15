package com.cookboy.cookboy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "recipes")
@AllArgsConstructor
public class Recipe {
    @Id
    private String id;

    private String title;

    private int time;

    private int portions;

    private String description;

    private Date createdAt;

    private List<Ingredient> ingredients;

    private String ownerId;

}