package com.bitbyteclub.SpendWise.bootstrap;

import com.bitbyteclub.SpendWise.entities.User;
import com.bitbyteclub.SpendWise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupCommandRunner implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        var user = new User();
        user.setFirstName("Iron");
        user.setLastName("Man");
        user.setEmail("ironman@xyz.com");
        user.setPassword("root");
        user.setAdmin(true);

        userService.registerUser(user);
    }
}
