/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.domain;

/**
 *
 * @author Rejina
 */
public class Product {
    private int productId;
    private String productName;
    private int quantity;
    private int sellingPrice;
    private int costPrice;

    public Product(int productId, String productName, int quantity, int sellingPrice, int costPrice) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    
    
    
    
}
