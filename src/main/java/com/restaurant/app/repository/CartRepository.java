package com.restaurant.app.repository;

import com.restaurant.app.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<ShoppingCart, Long> {

}
