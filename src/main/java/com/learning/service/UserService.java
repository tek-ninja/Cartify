package com.learning.service;

import com.learning.models.User;
import com.learning.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers () {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long targetId) {
        return userRepository.findById(targetId).stream().findFirst();
    }
    public void addUser(User user) { userRepository.save(user); }

    public User updateUser(User user) {

        Long targetId = user.getId();;
        User matchingUser = userRepository.findAll().stream().filter(user1 -> Objects.equals(user1.getId(), targetId))
                .findFirst().orElse(null);

        if (matchingUser != null) {
            matchingUser.setFirstName(user.getFirstName());
            matchingUser.setLastName(user.getLastName());
            userRepository.save(matchingUser);
        }
        return matchingUser;
    }
}
