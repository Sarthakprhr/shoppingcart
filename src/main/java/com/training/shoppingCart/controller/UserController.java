package com.training.shoppingCart.controller;

import com.training.shoppingCart.model.User;
import com.training.shoppingCart.requestWrapper.UserRequestWrapper;
import com.training.shoppingCart.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user/api")
public class UserController {

    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody UserRequestWrapper request)
    {
        userService.adduser(request);
        return ResponseEntity.ok("user added");

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserRequestWrapper request) {
        String token = userService.login(request.getUsername(), request.getPassword());
        if (token != null) {
            return ResponseEntity.ok(new User(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
