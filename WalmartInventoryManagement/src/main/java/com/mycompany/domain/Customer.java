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
public class Customer {
    private int customerId;
    private String customerName;
    private String address;
    private String contactNo;
    private int PAN_no;
    private int billNo;

    public Customer(int customerId, String customerName, String address, String contactNo, int PAN_no, int billNo) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.contactNo = contactNo;
        this.PAN_no = PAN_no;
        this.billNo = billNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public int getPAN_no() {
        return PAN_no;
    }

    public int getBillNo() {
        return billNo;
    }
    
}
