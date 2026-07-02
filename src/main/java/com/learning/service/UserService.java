package com.learning.service;

import com.learning.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    List<User> userList = new ArrayList<>();
    private Long autoID = 1L;

    public List<User> getUsers () {
        return userList;
    }
    public User getUserById(Long targetId) {
        User matchingUser = userList.stream()
                .filter(user -> user.getId() == targetId) // Filter by ID
                .findFirst()                             // Find the first match
                .orElse(null);                           // Return null if not found

        return matchingUser;
    }
    public List<User> addUser(User user) {
        user.setId(autoID++);
        userList.add(user);
        return userList;
    }
}
