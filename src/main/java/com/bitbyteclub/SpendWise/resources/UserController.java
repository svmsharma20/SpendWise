package com.bitbyteclub.SpendWise.resources;

import com.bitbyteclub.SpendWise.entities.User;
import com.bitbyteclub.SpendWise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/users/{email}")
    public User retrieveUser(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
}
