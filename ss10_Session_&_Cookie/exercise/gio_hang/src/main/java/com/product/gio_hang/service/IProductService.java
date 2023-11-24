package com.product.gio_hang.service;

import com.product.gio_hang.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(long id);
}
