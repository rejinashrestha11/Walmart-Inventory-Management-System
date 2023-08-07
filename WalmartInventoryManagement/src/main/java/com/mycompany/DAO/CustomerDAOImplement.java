/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVariable.db;
import com.mycompany.command.AddCustomer;
import com.mycompany.domain.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rejina
 */
@Repository
public class CustomerDAOImplement implements CustomerDAO{

    @Override
    public boolean addCustomer(int customerId, String customerName, String address,String contactNo, int PAN_no, int billNo) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if (findCustomer(customerId) == null) {
            AddCustomer cs = new AddCustomer(customerId,customerName, address,contactNo, PAN_no, billNo);
            String sql = "INSERT INTO `Walmart_db`.`customer` (`customerId`,`customerName`,`address`, `contactNo`,`PAN_no`, `billNo`) VALUES ('" + customerId + "', '" + customerName + "','" + address + "', '" + contactNo + "', '" + PAN_no + "', '" + billNo + "');";

            return db.iud(sql);
        }
        return false;
    
    }

    @Override
    public Customer findCustomer(int customerId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String sql = "select * from Walmart_db.customer WHERE customerId = '" + customerId + "';";
        ResultSet rs = db.select(sql);
        try {
            while (rs.next()) {
                Customer cs = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
                return cs;
            }
        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        return null;
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if (findCustomer(customerId) != null) {
            Customer cs = findCustomer(customerId);
            String sql = "DELETE FROM `Walmart_db`.`customer` WHERE (`customerId` = '" + cs.getCustomerId() + "');";
            return db.iud(sql);
        } else {
            return false;
        }
    }

    ArrayList<Customer> customer = new ArrayList<>();
    @Override
    public ArrayList<Customer> listCustomer() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return customer;
    }
    
}
