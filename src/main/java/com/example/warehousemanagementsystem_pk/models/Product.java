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
    private String ProductCode;

    @Column(name="Name")
    private String Name;

    @Column(name="Description")
    private String Description;

    @Column(name="Price")
    private double Price;

    @Column(name="QuantityInStock")
    private int QuantityInStock;

    @Column(name="Archived")
    private boolean Archived;
}
