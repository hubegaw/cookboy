package com.cookboy.cookboy.controller;

import com.cookboy.cookboy.entity.User;
import com.cookboy.cookboy.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{user_id}")
    public User findUserById(@PathVariable int user_id) {
        User user = userService.findById(user_id);

        if(user == null) {
            throw new RuntimeException("User with id '" + user_id + "' not found.");
        }

        return user;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setUserId(0);

        User newUser = userService.save(user);

        return newUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        User newUser = userService.save(user);

        return newUser;
    }

    @DeleteMapping("/users/{user_id}")
    public String deleteUser(@PathVariable int user_id) {
        User user = userService.findById(user_id);

        if (user == null) {
            throw new RuntimeException("User with id '" + user_id + "' does not exists.");
        }

        userService.deleteById(user_id);

        return "User with id '" + user_id + "' has been deleted";
    }

}
