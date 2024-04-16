package com.training.shoppingCart.service;

import com.training.shoppingCart.DTO.UserDto;
import com.training.shoppingCart.model.User;
import com.training.shoppingCart.repository.UserRepo;
import com.training.shoppingCart.requestWrapper.UserRequestWrapper;

public interface UserService {

    UserDto getUserByUsername(String username);

    String login(String username, String password);




    User createUser(UserRequestWrapper userDTO);

    User updateUser(Integer userId, UserRequestWrapper userDTO);

    String deleteUser(Integer userId);
}
