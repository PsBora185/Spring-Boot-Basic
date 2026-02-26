package com.example.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/hello")
    public String Hello(){
        return "Hello";
    }

    // spring boot converts automatically POJO to JSON using jackson
    @GetMapping("/user")
    public User getUser(){
        return new User("Jim", 22, "jim@gmail.com");
    }
}
