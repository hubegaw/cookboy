package com.cookboy.cookboy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document("users")
@AllArgsConstructor
@Getter
public class User {

    @Id
    private String id;
    private String email;
    private String name;
    private String password;
    @DBRef
    private List<String> recipesIds;
}
