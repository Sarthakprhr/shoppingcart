package com.training.shoppingCart.service.serviceImpl;

import com.training.shoppingCart.DTO.FavouriteDto;
import com.training.shoppingCart.exception.ResourceNotFoundException;
import com.training.shoppingCart.model.Favourite;
import com.training.shoppingCart.model.Product;
import com.training.shoppingCart.repository.FavouriteRepo;

import com.training.shoppingCart.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class FavouriteServiceImpl  implements FavouriteService {


    @Autowired
    private FavouriteRepo favouriteRepo;
    @Override
    public void addToFavourite(Product request) {
        Favourite favourite = new Favourite();
        favourite.setProducts((Set<Product>) request);



    }

    @Override
    public List<FavouriteDto> getfavouriteList() {
List<Favourite>  favourites = favouriteRepo.findAll();
  List<FavouriteDto> favouriteDtos = new ArrayList<>();

  for( Favourite favourite : favourites){
      FavouriteDto favouriteDto = new FavouriteDto();
      favouriteDto.setProducts(favourite.getProducts());
      favouriteDto.setFavouritetId(favourite.getFavouriteId());


      favouriteDtos.add(favouriteDto);
  }
  return favouriteDtos;

    }

    @Override
    public void removeitem(Integer favouriteId) {
    Favourite favourite = favouriteRepo.findById(favouriteId).orElseThrow(()-> new ResourceNotFoundException("favouriteItem","id", favouriteId));
    favouriteRepo.delete(favourite);

    }
}
