package com.product.gio_hang.service;

import com.product.gio_hang.model.Product;
import com.product.gio_hang.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return iProductRepository.findById(id).orElse(null);
    }
}
