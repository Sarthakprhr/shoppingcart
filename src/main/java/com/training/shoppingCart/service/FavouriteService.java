package com.training.shoppingCart.service;

import com.training.shoppingCart.DTO.FavouriteDto;
import com.training.shoppingCart.model.Product;


import java.util.List;


public interface FavouriteService {

    void addToFavourite ( Product request);
    List<FavouriteDto> getfavouriteList();

    void  removeitem ( Integer favouriteId);


}
