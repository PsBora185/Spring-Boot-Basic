package com.example.second.service;

import com.example.second.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> userDb = new HashMap<>();

    @PostConstruct
    public void initDb(){
        userDb.put("1", new User(1, "Joe", "joe@gmail.com"));
        userDb.put("2", new User(2, "Jenny", "jenny@gmail.com"));
    }

    public List<User> getUsers() {
        return new ArrayList<>(userDb.values());
    }
}
