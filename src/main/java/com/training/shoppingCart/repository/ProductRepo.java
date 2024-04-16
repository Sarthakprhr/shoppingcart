package com.training.shoppingCart.repository;

import com.training.shoppingCart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
