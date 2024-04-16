package com.training.shoppingCart.DTO;

import com.training.shoppingCart.model.Product;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class FavouriteDto {
    @Column(name = "id")
    private int favouritetId;
    @Column(name = "products")
    private Set<Product> products;


}
