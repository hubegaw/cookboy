package com.cookboy.cookboy.recipe;

import com.cookboy.cookboy.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="time")
    private int time;

    @Column(name="portions")
    private int portions;

    @Column(name="created_at")
    private Timestamp created_at;

    @Column(name="owner_id")
    private int ownerId;
}
