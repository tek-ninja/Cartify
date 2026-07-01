package com.learning.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.learning.models.User;

import java.util.ArrayList;
import java.util.List;

// Hello Controller for the initial welcome message
@RestController
public class HomeController {

    private List<User> userList = new ArrayList<>();

    @GetMapping("/api/users")
    public List<User> getUsers() {

        return userList;
    }

    @PostMapping("/api/users")
    public List<User> createUser(@RequestBody User user) {
        userList.add(user);
        return userList;
    }
}