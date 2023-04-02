package com.bitbyteclub.SpendWise.repository;

import com.bitbyteclub.SpendWise.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User getUserByEmail(String email);
}
