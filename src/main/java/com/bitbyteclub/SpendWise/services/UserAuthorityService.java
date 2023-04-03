package com.bitbyteclub.SpendWise.services;

import com.bitbyteclub.SpendWise.entities.UserAuthority;
import org.springframework.stereotype.Service;

@Service
public interface UserAuthorityService {
    UserAuthority addAuthority(String authority);

    void deleteAuthority(String authority);

    UserAuthority getAuthority(String authorityStr);
}

