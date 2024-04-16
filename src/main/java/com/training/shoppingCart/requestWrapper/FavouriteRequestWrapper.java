package com.training.shoppingCart.requestWrapper;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FavouriteRequestWrapper {
    @Column(name = "id")
    private int favouriteId;


}
