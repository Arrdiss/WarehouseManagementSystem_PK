package com.example.warehousemanagementsystem_pk.services;

import com.example.warehousemanagementsystem_pk.models.Product;
import com.example.warehousemanagementsystem_pk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findBy(String productCode) {
        return productRepository.findByProductCode(productCode);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }
}
