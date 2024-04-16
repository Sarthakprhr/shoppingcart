package com.training.shoppingCart.requestWrapper;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequestWrapper {
    @Column(name = "id")
    private int productId;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;
}
