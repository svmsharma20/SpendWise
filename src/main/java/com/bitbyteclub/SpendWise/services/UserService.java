package com.bitbyteclub.SpendWise.services;

import com.bitbyteclub.SpendWise.entities.User;
import com.bitbyteclub.SpendWise.entities.UserAuthority;
import jakarta.annotation.Nonnull;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

public interface UserService extends UserDetailsService {
    User registerUser(User user);
    User getUserByEmail(@Nonnull String email);
    User addAuthority(String email, Set<String> authority);
}
