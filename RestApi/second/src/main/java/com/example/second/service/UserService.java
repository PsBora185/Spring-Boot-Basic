package com.example.second.service;

import com.example.second.entity.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String , User> userDb = new HashMap<>();

}
