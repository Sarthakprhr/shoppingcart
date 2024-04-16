package com.training.shoppingCart.repository;

import com.training.shoppingCart.model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FavouriteRepo extends JpaRepository<Favourite,Integer> {
}
