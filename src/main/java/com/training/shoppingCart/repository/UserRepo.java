package com.training.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.training.shoppingCart.model.User;

import java.util.Optional;

@Repository

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
