package com.example.shopapi.controllers;

import com.example.shopapi.entities.User;
import com.example.shopapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@ResponseBody
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")//add
    public User createUser(@Validated @RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/user/{id}")//delete
    public void deleteUser(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
    }

    @GetMapping("/users") //get list of all users
    public List<User> getListOfUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        User foundUser = userRepository.findById(id).orElseThrow();
        foundUser.setName(user.getName());
        foundUser.setStatus(user.getStatus());
        return userRepository.save(foundUser);
    }

}