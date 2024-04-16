package com.training.shoppingCart.service;

import com.training.shoppingCart.requestWrapper.UserRequestWrapper;

public interface UserService {

    String login(String username, String password);


    void adduser(UserRequestWrapper request);
}
