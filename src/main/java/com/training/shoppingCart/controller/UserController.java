package com.training.shoppingCart.controller;

import com.training.shoppingCart.DTO.UserDto;
import com.training.shoppingCart.constant.WebConstants;
import com.training.shoppingCart.model.User;
import com.training.shoppingCart.requestWrapper.UserRequestWrapper;
import com.training.shoppingCart.response.JSONObject;
import com.training.shoppingCart.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/user/api")
public class UserController {

    @Autowired
    private UserService userservice;


    @Autowired
    private MessageSource messageSource;
    @PostMapping("/")
    public ResponseEntity<JSONObject> createUser(@RequestBody UserRequestWrapper request )
    {
        userservice.createUser(request);
        String message = messageSource.getMessage("userAddSuccess", null, Locale.ENGLISH);
        JSONObject data = new JSONObject(WebConstants.KEY_STATUS_SUCCESS, 200, message );
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    //put-updateuser
    @PutMapping("/{userid}")
    public ResponseEntity<JSONObject> updateUser (@RequestBody UserRequestWrapper request,

                                                  @PathVariable ("userid")Integer userid )
    {
        userservice.updateUser(userid,request);
        String message = messageSource.getMessage("userUpdateSuccess", null,  Locale.ENGLISH);
        JSONObject data = new JSONObject(WebConstants.KEY_STATUS_SUCCESS, 200, message);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        // Call the service method to delete the user
        String responseMessage = userservice.deleteUser(id);

        // Return the response message
        return ResponseEntity.ok(responseMessage);
    }
    @GetMapping("/username/{username}")
    public ResponseEntity<UserDto> getUserByUsername(@PathVariable String username) {
        // Call the service method to get the user by username
        UserDto userDto = userservice.getUserByUsername(username);

        // Check if userDto is null
        if (userDto == null) {
            // Return 404 Not Found if the user is not found
            return ResponseEntity.notFound().build();
        }

        // Return the userDto as the response body
        return ResponseEntity.ok(userDto);
    }
}
