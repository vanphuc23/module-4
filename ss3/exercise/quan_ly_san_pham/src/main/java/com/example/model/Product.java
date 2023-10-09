package com.example.model;

public class Product {
    private int id;
    private String productName;
    private double price;
    private String describeProduct;
    private String producer;

    public Product() {
    }

    public Product(int id, String productName, double price, String describeProduct, String producer) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.describeProduct = describeProduct;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
