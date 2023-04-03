package com.bitbyteclub.SpendWise.services.impl;

import com.bitbyteclub.SpendWise.entities.UserAuthority;
import com.bitbyteclub.SpendWise.repository.UserAuthorityRepository;
import com.bitbyteclub.SpendWise.services.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthorityServiceImpl implements UserAuthorityService{

    @Autowired
    private UserAuthorityRepository userAuthorityRepository;

    @Override
    public UserAuthority addAuthority(String authority){
        return userAuthorityRepository.save(new UserAuthority(authority.toUpperCase()));
    }

    @Override
    public void deleteAuthority(String authority){
        userAuthorityRepository.delete(new UserAuthority(authority.toUpperCase()));
    }

    @Override
    public UserAuthority getAuthority(String authorityStr){
       return userAuthorityRepository.findByAuthority(authorityStr);
    }
}
