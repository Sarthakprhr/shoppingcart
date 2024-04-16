package com.training.shoppingCart.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int productId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User Users;

    @ManyToOne
    @JoinColumn(name = "favourite_id", nullable = false)
    private Favourite favourite;

}
