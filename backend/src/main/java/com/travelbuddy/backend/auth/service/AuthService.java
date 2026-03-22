package com.travelbuddy.backend.auth.service;

import com.travelbuddy.backend.auth.dto.RegisterResponse;
import com.travelbuddy.backend.auth.entity.User;
import com.travelbuddy.backend.auth.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import com.travelbuddy.backend.auth.util.PasswordHasher;
@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public RegisterResponse register(String email, String password){

        if(userRepository.existsByEmail(email)){
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setId(UUID.randomUUID());
        user.setEmail(email);
        user.setPasswordHash(PasswordHasher.hash(password));
        user.setStatus("ACTIVE");
        user.setCreatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);
        RegisterResponse response = new RegisterResponse();
        response.setId(savedUser.getId());
        response.setEmail(savedUser.getEmail());
        response.setStatus(savedUser.getStatus());
        response.setCreatedAt(savedUser.getCreatedAt());

        return response;



    }
}
