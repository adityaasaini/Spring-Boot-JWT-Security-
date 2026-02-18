package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.test.entity.AppUser;
import com.example.test.repo.UserRepositry;

@SpringBootApplication
public class Sb1Security2ModfieApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(Sb1Security2ModfieApplication.class, args);
        UserRepositry userRepo = ctx.getBean(UserRepositry.class);
        PasswordEncoder encoder = ctx.getBean(PasswordEncoder.class);   // PasswordEncoder bean अलग फाइल में है

        // admin
        // Fix: findbyUsername → findByUsername
        if (userRepo.findByUsername("admin").isEmpty()) {
            AppUser appUser = new AppUser();
            appUser.setUsername("admin");
            appUser.setPassword(encoder.encode("admin123"));
            appUser.setRole("ROLE_ADMIN");
            userRepo.save(appUser);
            System.out.println("ADMIN INSERT");
        } else {
            System.out.println("ADMIN ALREADY EXIST");
        }

        // member
        // Fix: findbyUsername → findByUsername
        if (userRepo.findByUsername("member").isEmpty()) {
            AppUser appUser = new AppUser();
            appUser.setUsername("member");
            appUser.setPassword(encoder.encode("member123"));
            appUser.setRole("ROLE_MEMBER");
            userRepo.save(appUser);
            System.out.println("MEMBER INSERT");
        } else {
            System.out.println("MEMBER ALREADY EXIST");
        }
    }
}
