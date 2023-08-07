/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.controller.DbConnection;

/**
 *
 * @author Rejina
 */
public interface DatabaseVariable {
    public static final DbConnection db= new DbConnection();
}
