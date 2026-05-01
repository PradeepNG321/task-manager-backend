package com.taskmanager.taskmanager.controller;

import com.taskmanager.taskmanager.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = new ArrayList<>();

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        users.add(user);
        return "User registered: " + user.getName();
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return users;
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        for (User u : users) {
            if (u.getEmail().equals(user.getEmail()) &&
                    u.getPassword().equals(user.getPassword())) {
                return "Login Successful";
            }
        }

        return "Invalid Email or Password";
    }
}

