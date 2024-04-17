package com.training.shoppingCart.model;


import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private  int id;
    @NotNull
    @Column( name = "name")
    private String username;

    @NotNull
    @Column(name="email", unique = true)
    private String email;
    @NotNull
    @Column(name="password")
    private String password;
     @Column(name="roles")
     private String roles;



    @OneToMany(mappedBy = "Users", cascade = CascadeType.ALL)
    private Set<Product> products;
    @OneToOne(mappedBy = "Users", cascade = CascadeType.ALL)
    private Favourite favourite;


   
}
