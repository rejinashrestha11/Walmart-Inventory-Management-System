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
public class Admin {
    private String userName;
    private String address;
    private String contactNo;
    private String passWord;
    

    public Admin(String userName, String address, String contactNo, String passWord) {
        this.userName = userName;
        this.address = address;
        this.contactNo = contactNo;
        this.passWord = passWord;
       
    }

    public Admin(String string, String string0, String string1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Admin() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUserName() {
        return userName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNo() {
        return contactNo;
    }
    
    

    public String getPassWord() {
        return passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

   
    
}
