package com.aashish.sql.controller;

import com.aashish.sql.model.User;
import com.aashish.sql.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User makeUser(@RequestBody User user) {
        User saved = userRepository.save(user);
        System.out.println(saved.getName());
        return user;
    }


    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        userRepository.save(user);
        return user;
    }
}
