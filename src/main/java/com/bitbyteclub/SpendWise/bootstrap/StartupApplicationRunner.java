package com.bitbyteclub.SpendWise.bootstrap;

import com.bitbyteclub.SpendWise.entities.User;
import com.bitbyteclub.SpendWise.entities.UserAuthority;
import com.bitbyteclub.SpendWise.services.UserAuthorityService;
import com.bitbyteclub.SpendWise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class StartupApplicationRunner implements ApplicationRunner {

    @Autowired
    UserService userService;

    @Autowired
    UserAuthorityService authorityService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        var userAuthority = new UserAuthority("USER");
        authorityService.addAuthority(userAuthority);

        var adminAuthority = new UserAuthority("ADMIN");
        authorityService.addAuthority(adminAuthority);

        var user = new User();
        user.setFirstName("Iron");
        user.setLastName("Man");
        user.setEmail("ironman@xyz.com");
        user.setPassword("root");
        userService.registerUser(user);

        userService.addAuthority("ironman@xyz.com", Set.of("ADMIN"));
    }
}
