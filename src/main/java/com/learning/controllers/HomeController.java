package com.learning.controllers;

import com.learning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.learning.models.User;
import org.springframework.http.*;
import java.util.List;

// Hello Controller for the initial welcome message
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class HomeController {

    private final UserService userService;

    //@GetMapping("/api/users") is a combination of RequestMapping + GET
    //@RequestMapping(value="/api/users", method=RequestMethod.GET)
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
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
    @PostMapping
    public ResponseEntity<List<User>> createUser(@RequestBody User user) {

        return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        if(updateUser == null)
            return ResponseEntity.notFound().build();

        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

}