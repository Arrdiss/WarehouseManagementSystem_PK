package com.example.warehousemanagementsystem_pk.repository;

import com.example.warehousemanagementsystem_pk.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByProductCode(String productCode);

}

