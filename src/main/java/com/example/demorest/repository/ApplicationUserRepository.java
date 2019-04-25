package com.example.demorest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demorest.model.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    ApplicationUser findByUsername(String username);
}