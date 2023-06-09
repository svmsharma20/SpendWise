package com.bitbyteclub.SpendWise.resources;

import com.bitbyteclub.SpendWise.entities.User;
import com.bitbyteclub.SpendWise.entities.UserAuthority;
import com.bitbyteclub.SpendWise.services.UserService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/users/{username}")
    @RolesAllowed({"ADMIN"})
    public User retrieveUser(@PathVariable String username){
        return userService.getUserByUsername(username);
    }

    @PutMapping("/users/{username}")
//    @RolesAllowed({"ADMIN"})
    public User addUserAuthority(@PathVariable String username, @RequestBody Set<String> authority){
        return userService.addAuthority(username, authority);
    }
}
