/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.domain.Admin;
import java.util.ArrayList;

/**
 *
 * @author Rejina
 */
public interface AdminDAO {
    public boolean login(String userName, String passWord);
    public boolean addUser(String userName, String address, String contactNo, String passWord, String confirmPassWord);
    public Admin findUser (String userName);
    public boolean deleteUser(String userName);
    public ArrayList<Admin> listUser();
}


