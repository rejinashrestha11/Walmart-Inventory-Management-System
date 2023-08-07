/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.Product;
import java.util.ArrayList;

/**
 *
 * @author Rejina
 */
public interface ProductDAO {
    public boolean addProduct(int productId, String productName, int quantity, int sellingPrice, int costPrice);
    public Product findProduct (int productId);
    public ArrayList<Product> listProduct();
    public boolean revokeProduct (int productId, int quantity);
    
}
