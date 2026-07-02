package com.learning.controllers;

import com.learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.learning.models.User;
import org.springframework.http.*;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;

// Hello Controller for the initial welcome message
@RestController
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    //@GetMapping("/api/users") is a combination of RequestMapping + GET
    @RequestMapping(value="/api/users", method=RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
        /*
        User user = userService.getUserById(id);
        if(user == null)
            return ResponseEntity.notFound().build();
        return new ResponseEntity<>(user,HttpStatus.FOUND);
         */
    }
    @PostMapping("/api/users")
    public ResponseEntity<List<User>> createUser(@RequestBody User user) {

        return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
    }
    @PutMapping("/api/users")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        if(user == null)
            return ResponseEntity.notFound().build();

        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

}