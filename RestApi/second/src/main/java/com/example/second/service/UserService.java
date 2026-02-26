package com.example.second.service;

import com.example.second.entity.User;
import jakarta.annotation.PostConstruct;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final Map<Integer, User> userDb = new HashMap<>();

    @PostConstruct
    public void initDb() {
        userDb.put(1, new User(1, "Joe", "joe@gmail.com"));
        userDb.put(2, new User(2, "Jenny", "jenny@gmail.com"));
        System.out.println("Added two users.");
    }

    public List<User> getUsers() {
        return new ArrayList<>(userDb.values());
    }

    public void addUser(User user) {
        userDb.put(user.getId(), user);
    }

    public void updateUser(User user) {
        userDb.put(user.getId(), user);
    }

    public boolean checkIfExist(int id) {
        return userDb.containsKey(id);
    }

    public void deleteUser(int id) {
        userDb.remove(id);
    }

    public @Nullable User getById(int id) {
        return userDb.get(id);
    }
}
