package com.example.chat.controller;

import com.example.chat.model.User;
import com.example.chat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // SIGNUP
    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userRepository.save(user);
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User loginReq) {
        User user = userRepository.findByEmail(loginReq.getEmail())
                .orElse(null);

        if (user == null) return null;

        if (passwordEncoder.matches(loginReq.getPasswordHash(), user.getPasswordHash())) {
            return user;
        }

        return null;
    }
}
