package com.example.second.controller;

import com.example.second.entity.User;
import com.example.second.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<User>> users() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        if (userService.checkIfExist(user.getId()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(userService.getById(user.getId()));

        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        if (!userService.checkIfExist(user.getId()))
            return ResponseEntity.notFound().build();

        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        if (!userService.checkIfExist(id))
            return ResponseEntity.notFound().build();

        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        if (!userService.checkIfExist(id))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(userService.getById(id));
    }

}
