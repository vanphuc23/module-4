package com.product.gio_hang.repository;

import com.product.gio_hang.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
