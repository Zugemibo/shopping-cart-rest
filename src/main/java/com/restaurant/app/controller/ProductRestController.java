package com.restaurant.app.controller;

import com.restaurant.app.model.Product;
import com.restaurant.app.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductRestController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/products")
    public @ResponseBody
    ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productServiceImpl.getAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.FOUND);
    }

    @GetMapping("/products/{id}")
    public @ResponseBody
    ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productServiceImpl.getProductById(id);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping("/products/name/{name}")
    public @ResponseBody ResponseEntity<List<Product>> getProductByName(@PathVariable("name") String name){
        List<Product> products = productServiceImpl.getProductByName(name);
        return new ResponseEntity<List<Product>>(products, HttpStatus.FOUND);
    }
    @GetMapping("/products/size/{size}")
    public @ResponseBody ResponseEntity<List<Product>> getProductBySize(@PathVariable("size") int size){
        List<Product> products = productServiceImpl.getProductBySize(size);
        return new ResponseEntity<List<Product>>(products, HttpStatus.FOUND);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productServiceImpl.addProduct(product);
    }

    @PutMapping("/products/{id}")
    public @ResponseBody
    ResponseEntity<Product> updateProductById(@PathVariable("id") Long id, @RequestBody Product product) {
        Product currentProduct = productServiceImpl.getProductById(id);

        if (currentProduct == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        currentProduct.setName(product.getName());
        currentProduct.setDescription(product.getDescription());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setSize(product.getSize());
        productServiceImpl.updateProduct(currentProduct);
        return new ResponseEntity<>(currentProduct, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public @ResponseBody
    ResponseEntity<Product> deleteProductById(@PathVariable("id") Long id) {
        productServiceImpl.deleteProductById(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

}
