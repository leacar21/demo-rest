package com.example.demorest.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demorest.model.ApplicationUser;

public interface UserService extends UserDetailsService {

    public void saveUser(ApplicationUser user);
}