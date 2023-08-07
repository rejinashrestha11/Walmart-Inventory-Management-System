/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import static com.mycompany.DAO.DatabaseVariable.db;
import com.mycompany.command.AddUser;
import com.mycompany.domain.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rejina
 */
@Repository
public class AdminDAOImplement implements AdminDAO{

    @Override
    public boolean login(String userName, String passWord) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String sql = "select * from Walmart_db.admin;";
        ResultSet rs = db.select(sql);
        try {
            while (rs.next()) {
                Admin ad = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                if (ad.getUserName().equalsIgnoreCase(userName) && ad.getPassWord() .equals(passWord)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            return false;
        }

        if (userName.equalsIgnoreCase("admin") && passWord.equals("admin")) {
            return true;
        }
        System.out.println("Invalid Login!!");
        return false;
    }
    
    
    @Override
    public Admin findUser(String userName) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = "select * from Walmart_db.admin WHERE userName = '" + userName + "';";
        ResultSet rs = db.select(sql);
        try {
            while (rs.next()) {
                Admin ad = new Admin(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                return ad;
            }
        } catch (SQLException ex) {
            System.out.println("Database Error");
        }
        return null;
    }


    @Override
    public boolean addUser(String userName, String address, String contactNo, String passWord, String confirmPassWord) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if (findUser(userName) == null) {
            AddUser ad = new AddUser(userName, address, contactNo, passWord, confirmPassWord);
            String sql = "INSERT INTO `Walmart_db`.`admin` (`userName`,`address`,`contactNo`, `passWord`) VALUES ('" + userName + "', '" + address + "','" + contactNo + "', '" + passWord + "');";

            return db.iud(sql);
        }
        return false;
    }

    @Override
    public boolean deleteUser(String userName) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (findUser(userName) != null) {
            Admin ad = findUser(userName);
            String sql = "DELETE FROM `Walmart_db`.`admin` WHERE (`userName` = '" + ad.getUserName() + "');";
            return db.iud(sql);
        } else {
            return false;
        }
    }

ArrayList<Admin> user = new ArrayList<>();

    @Override
    public ArrayList<Admin> listUser() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        return user;
    
    }
}
