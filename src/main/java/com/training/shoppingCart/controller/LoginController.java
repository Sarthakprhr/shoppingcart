package com.training.shoppingCart.controller;


import com.training.shoppingCart.login.LoginRequest;
import com.training.shoppingCart.login.LoginResponse;
import com.training.shoppingCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = userService.login(request.getUsername(), request.getPassword());
        if (token != null) {
            return ResponseEntity.ok(new LoginResponse(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}