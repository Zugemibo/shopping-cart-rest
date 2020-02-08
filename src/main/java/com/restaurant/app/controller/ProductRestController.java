package com.restaurant.app.controller;

import com.restaurant.app.model.Product;
import com.restaurant.app.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping(value = {"", "/"})
    public @NotNull List<Product> getProducts() {
        return productServiceImpl.getAllProducts();
    }

    /*@PostMapping("/addToCart")
    public Product addToCart(Product product) {
        product.setCartItem();

        return null;
    }*/
}
