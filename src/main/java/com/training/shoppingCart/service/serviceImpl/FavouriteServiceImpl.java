package com.training.shoppingCart.service.serviceImpl;

import com.training.shoppingCart.DTO.FavouriteDto;
import com.training.shoppingCart.requestWrapper.ProductRequestWrapper;
import com.training.shoppingCart.service.FavouriteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavouriteServiceImpl  implements FavouriteService {
    @Override
    public void addToFavourite(ProductRequestWrapper request) {

    }

    @Override
    public List<FavouriteDto> getfavouriteList() {
        return null;
    }

    @Override
    public void removeitem(Integer favouriteId) {

    }
}
