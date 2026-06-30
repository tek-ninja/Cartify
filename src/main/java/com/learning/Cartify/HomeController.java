package com.learning.Cartify;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// Hello Controller for the initial welcome message
@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Cartify!";
    }
}