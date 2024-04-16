package com.training.shoppingCart.DTO;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class FavouriteDto {
    @Column(name = "id")
    private int favouritetId;


}
