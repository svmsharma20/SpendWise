package com.bitbyteclub.SpendWise.services.impl;

import com.bitbyteclub.SpendWise.entities.User;
import com.bitbyteclub.SpendWise.entities.UserAuthority;
import com.bitbyteclub.SpendWise.repository.UserRepository;
import com.bitbyteclub.SpendWise.services.UserAuthorityService;
import com.bitbyteclub.SpendWise.services.UserService;
import jdk.jfr.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAuthorityService authorityService;

    @Override
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByEmail(username);
    }

    @Override
    public User addAuthority(String email, Set<String> authority){
        User user = getUserByEmail(email);
        var authoritySet = authority.stream().map(auth -> authorityService.getAuthority(auth)).collect(Collectors.toSet());
        if(user == null || authoritySet==null || authoritySet.isEmpty()){
            return null;
        }
        authoritySet.stream().forEach (auth -> user.addAuthority(auth));

        return userRepository.save(user);
    }
}
