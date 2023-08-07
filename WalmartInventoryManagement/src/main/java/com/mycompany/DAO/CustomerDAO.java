/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.Customer;
import java.util.ArrayList;

/**
 *
 * @author Rejina
 */
public interface CustomerDAO {
    public boolean addCustomer(int customerId, String customerName, String address, String contactNo, int PAN_no, int billNo);
    public Customer findCustomer (int customerId);
    public boolean deleteCustomer(int customerId);
    public ArrayList<Customer> listCustomer();
    
}
