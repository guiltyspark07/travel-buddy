package com.travelbuddy.backend.auth.controller;

import com.travelbuddy.backend.auth.dto.LoginRequest;
import com.travelbuddy.backend.auth.dto.LoginResponse;
import com.travelbuddy.backend.auth.dto.RegisterRequest;
import com.travelbuddy.backend.auth.dto.RegisterResponse;
import com.travelbuddy.backend.auth.entity.User;
import com.travelbuddy.backend.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @RequestMapping("/register")
    public RegisterResponse register(@Valid @RequestBody RegisterRequest request){
        return authService.register(request.getEmail(), request.getPassword());
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request){
        return authService.login(request.getEmail(), request.getPassword());
    }

}
