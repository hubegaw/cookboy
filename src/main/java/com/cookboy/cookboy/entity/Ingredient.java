package com.cookboy.cookboy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingredient {
    private String name;

    private double amount;

    private String measure;
}
