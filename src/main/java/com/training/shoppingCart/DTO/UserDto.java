package com.training.shoppingCart.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    @Column(name="id")
    private  int id;

    @Column( name = "name")
    private String name;
    @Column(name="email",unique = true)
    private String email;
    @Column(name="password")
    private String password;
}
