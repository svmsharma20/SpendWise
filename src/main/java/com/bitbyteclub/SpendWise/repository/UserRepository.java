package com.bitbyteclub.SpendWise.repository;

import com.bitbyteclub.SpendWise.entities.User;
import jakarta.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User getUserByEmail(String email);
    User getUserByUsername(String username);
}
