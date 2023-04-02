package com.bitbyteclub.SpendWise.repository;

import com.bitbyteclub.SpendWise.entities.UserAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {
    UserAuthority findByAuthority(String authorityStr);
}
