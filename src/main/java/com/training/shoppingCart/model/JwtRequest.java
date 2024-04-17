package com.training.shoppingCart.model;

import lombok.Data;

@Data
public class JwtRequest {
    private String email;
    private String password;

}
