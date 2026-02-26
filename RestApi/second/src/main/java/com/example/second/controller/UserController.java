package com.example.second.controller;

import com.example.second.entity.User;
import com.example.second.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        if (userService.checkIfExist(user.getId()))
            return "User already exist with this id.";
        userService.addUser(user);
        return "User Created.";
    }

    @PutMapping
    public String updateUser(@RequestBody User user) {
        if (userService.checkIfExist(user.getId())) {
            userService.updateUser(user);
            return "User updated.";
        }

        userService.addUser(user);
        return "User doesn't exists, Created new user.";
    }

    @DeleteMapping
    public String deleteUser(int id) {
        if (userService.checkIfExist(id)) {
            userService.deleteUser(id);
            return "User deleted.";
        }
        return "User with this id doesn't exist.";
    }
}
