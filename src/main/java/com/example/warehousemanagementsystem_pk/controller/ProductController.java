package com.example.warehousemanagementsystem_pk.controller;

import com.example.warehousemanagementsystem_pk.models.Product;
import com.example.warehousemanagementsystem_pk.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        final var result = productService.save(product);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/one/{productCode}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productCode") String productCode) {
        productService.findBy(productCode).ifPresent(product -> productService.delete(product));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
