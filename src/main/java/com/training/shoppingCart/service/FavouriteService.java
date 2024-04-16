package com.training.shoppingCart.service;

import com.training.shoppingCart.DTO.FavouriteDto;
import com.training.shoppingCart.requestWrapper.ProductRequestWrapper;

import java.util.List;


public interface FavouriteService {

    void addToFavourite ( ProductRequestWrapper request);
    List<FavouriteDto> getfavouriteList();

    void  removeitem ( Integer favouriteId);


}
