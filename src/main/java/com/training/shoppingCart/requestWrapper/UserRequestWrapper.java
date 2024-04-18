package com.training.shoppingCart.requestWrapper;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestWrapper {
    @Column(name="id")
    private  int id;

    @Column( name = "name")
    private String username;
    @Column(name="email",unique = true)
    private String email;
    @Column(name="password")
    private String password;
//
//    @Column(name="roles")
//    private String roles;



}
