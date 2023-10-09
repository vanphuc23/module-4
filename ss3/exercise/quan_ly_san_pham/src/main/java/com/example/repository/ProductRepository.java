package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> list = new ArrayList<>();

    static {
        list.add(new Product(1, "Cookie", 5000, "Delicious", "Oishi"));
        list.add(new Product(2, "Candy", 2000, "Sweet", "Oishi"));
        list.add(new Product(3, "Milo", 10000, "Delicious", "Milo"));
    }

    @Override
    public List<Product> show() {
        return list;
    }

    @Override
    public void add(Product product) {
        list.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : list
        ) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(int id, Product product) {
        int index;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                list.set(index, product);
            }
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
            }
        }
    }

    @Override
    public List<Product> search(String productName) {
        List<Product> productList = new ArrayList<>();
        for (Product product : list
        ) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                productList.add(product);
            }
        }
        return productList;
    }
}
