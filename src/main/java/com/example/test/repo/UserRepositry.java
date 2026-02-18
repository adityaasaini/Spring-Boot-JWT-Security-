package com.example.test.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.entity.AppUser;

public interface UserRepositry extends JpaRepository<AppUser, Long> {

    // Fix: findbyUsername → findByUsername
    Optional<AppUser> findByUsername(String username);   // <-- B capital

}
