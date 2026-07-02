package com.learning.controllers;

import com.learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.learning.models.User;
import com.learning.service.UserService;

import java.util.ArrayList;
import java.util.List;

// Hello Controller for the initial welcome message
@RestController
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping("/api/users")
    public List<User> createUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}