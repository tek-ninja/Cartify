package com.learning.models;

import lombok.Data;

//Used lombook
@Data
public class User {

    private Long id;
    private String firstName;
    private String lastName;

    public User() {
    }

}
