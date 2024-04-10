package com.example.product.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Product> products;

    public Category() {
    }

    public Long getIdCategory() {
        return id;
    }

    public void setIdCategory(Long idCategory) {
        this.id = idCategory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
