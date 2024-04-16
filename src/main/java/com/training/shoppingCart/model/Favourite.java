package com.training.shoppingCart.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Entity
@Getter
@Setter
public class Favourite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int favouriteId;


    @OneToMany(mappedBy = "favourite", cascade = CascadeType.ALL)
    private Set<Product> products;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User Users;


}
