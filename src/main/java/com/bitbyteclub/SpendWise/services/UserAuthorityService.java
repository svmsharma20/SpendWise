package com.bitbyteclub.SpendWise.services;

import com.bitbyteclub.SpendWise.entities.UserAuthority;
import org.springframework.stereotype.Service;

@Service
public interface UserAuthorityService {
    UserAuthority addAuthority(UserAuthority authority);

    void deleteAuthority(UserAuthority authority);

    UserAuthority getAuthority(String authorityStr);
}

