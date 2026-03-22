package com.travelbuddy.backend.auth.controller;

import com.travelbuddy.backend.auth.dto.RegisterRequest;
import com.travelbuddy.backend.auth.entity.User;
import com.travelbuddy.backend.auth.service.AuthService;
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
    public User register(@RequestBody RegisterRequest request){
        return authService.register(request.getEmail(), request.getPassword());
    }

}
