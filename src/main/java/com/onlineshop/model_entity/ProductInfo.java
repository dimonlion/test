package com.onlineshop.model_entity;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.onlineshop.model.Product;


 
public class ProductInfo {
    private Long code;
    private String name;
    private double price;
 
    private boolean newProduct=false;
 
    // Upload file.
    private CommonsMultipartFile fileData;
 
    public ProductInfo() {
    }
 
    public ProductInfo(Product product) {
        this.code = product.getProductId();
        this.name = product.getProductName();
        this.price = product.getProductPrice();
    }
 
    public ProductInfo(Long code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
 
    public Long getCode() {
        return code;
    }
 
    public void setCode(Long code) {
        this.code = code;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    public CommonsMultipartFile getFileData() {
        return fileData;
    }
 
    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }
 
    public boolean isNewProduct() {
        return newProduct;
    }
 
    public void setNewProduct(boolean newProduct) {
        this.newProduct = newProduct;
    }
 
}