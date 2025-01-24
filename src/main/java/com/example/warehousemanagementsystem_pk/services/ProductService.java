package com.example.warehousemanagementsystem_pk.services;

import com.example.warehousemanagementsystem_pk.models.Product;
import com.example.warehousemanagementsystem_pk.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
