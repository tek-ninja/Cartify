package com.learning.controllers;

import com.learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if(user == null)
            return ResponseEntity.notFound().build();
        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }
    @PostMapping("/api/users")
    public ResponseEntity<List<User>> createUser(@RequestBody User user) {

        return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
    }
}