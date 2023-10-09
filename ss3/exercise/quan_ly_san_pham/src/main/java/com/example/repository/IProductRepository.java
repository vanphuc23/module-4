package com.example.repository;

import com.example.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> show();

    void add(Product product);

    Product findById(int id);

    void update(int id, Product product);

    void delete(int id);

    List<Product> search(String productName);
}
