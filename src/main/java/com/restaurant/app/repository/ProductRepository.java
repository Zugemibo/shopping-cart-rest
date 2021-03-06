package com.restaurant.app.repository;

import com.restaurant.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(Long id);

    List<Product> getProductByName(String name);

    List<Product> getProductBySize(int size);
}
