package entities;

import entities.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Product {
    @Id
    String productCode;

    @NotNull
    String productName;

    @NotNull
    int amount;

    @NotNull
    Category category;

    @NotNull
    Boolean archive;

    public Product() {}

    public Product(String productCode, String productName, int amount, Category category) {
        this.productCode = productCode;
        this.productName = productName;
        this.amount = amount;
        this.category = category;
        this.archive = false;
    }
}