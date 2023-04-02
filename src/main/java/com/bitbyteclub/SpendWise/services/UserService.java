package com.bitbyteclub.SpendWise.services;

import com.bitbyteclub.SpendWise.entities.User;
import jakarta.annotation.Nonnull;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User registerUser(User user);
    User getUserByEmail(@Nonnull String email);
}
