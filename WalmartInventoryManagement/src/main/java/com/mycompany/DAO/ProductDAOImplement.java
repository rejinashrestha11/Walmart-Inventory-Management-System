/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVariable.db;
import com.mycompany.command.AddProduct;
import com.mycompany.command.RevokeProduct;
import com.mycompany.domain.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rejina
 */

@Repository
public class ProductDAOImplement implements ProductDAO{

    @Override
    public boolean addProduct(int productId, String productName, int quantity, int sellingPrice, int costPrice) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if (findProduct(productId) == null) {
            AddProduct pd = new AddProduct(productId, productName, quantity, sellingPrice, costPrice);
            String sql = "INSERT INTO `Walmart_db`.`product` (`productId`,`productName`,`quantity`, `sellingPrice`,`costPrice`) VALUES ('" + productId + "', '" + productName + "','" + quantity + "', '" + sellingPrice + "', '" + costPrice + "');";

            return db.iud(sql);
        }
        return false;
    
    }

    @Override
    public Product findProduct(int productId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String sql = "select * from Walmart_db.product WHERE productId = '" + productId + "';";
        ResultSet rs = db.select(sql);
        try {
            while (rs.next()) {
                Product pd = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getInt(4), rs.getInt(5));
                return pd;
            }
        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        return null;    
    }

    ArrayList<Product> product = new ArrayList<>();
    @Override
    public ArrayList<Product> listProduct() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return product;
    }

    @Override
    public boolean revokeProduct(int productId, int quantity) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     //if (findProduct(productId) != null) {
            Product pd = findProduct(productId);
            pd.setQuantity(pd.getQuantity()- quantity);
            String sql = "UPDATE `Walmart_db`.`product` SET `quantity` = '" + pd.getQuantity() + "' WHERE (`productId` = '" + pd.getProductId() + "');";

                return db.iud(sql);
   //         }
   //     return false;
    }
}
    