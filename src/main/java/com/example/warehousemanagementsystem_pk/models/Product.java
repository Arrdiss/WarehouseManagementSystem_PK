package com.example.warehousemanagementsystem_pk.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Setter
@Accessors(chain = true)
@Entity
@Table(name = "Products")
@Data
public class Product {
    @Id
    @Column(name="ProductCode")
    private String productCode;

    @Column(name="Name")
    private String name;

    @Column(name="Description")
    private String description;

    @Column(name="Price")
    private Double price;

    @Column(name="QuantityInStock")
    private Integer quantityInStock;

    @Column(name="Archived")
    private Boolean archived;
}
