package com.learning.service;

import com.learning.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList = new ArrayList<>();

    public List<User> getUsers () {
        return userList;
    }
    public List<User> addUser(User user) {
        userList.add(user);
        return userList;
    }
}
