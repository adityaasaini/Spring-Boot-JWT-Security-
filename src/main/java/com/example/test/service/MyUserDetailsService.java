package com.example.test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.test.entity.AppUser;
import com.example.test.repo.UserRepositry;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepositry userRepositry;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Fix: findbyUsername → findByUsername
        Optional<AppUser> opUser = userRepositry.findByUsername(username);
        AppUser appUser = null;

        if (opUser.isPresent()) {
            appUser = opUser.get();
        } else {
            throw new UsernameNotFoundException("user name not found");
        }

        UserDetails userDetails = User
                .builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .roles(appUser.getRole().replace("ROLE_", ""))
                .build();

        return userDetails;
    }
}
