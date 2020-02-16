package com.restaurant.app.service;

import com.restaurant.app.repository.ProductRepository;
import com.restaurant.app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Product product = productRepository.findProductById(id);
        return product;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product currentProduct) {
        return productRepository.save(currentProduct);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
