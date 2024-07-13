/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jpadilla.app.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author jhonatan
 */
public class MysqlConnect {
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/myfood";
    private static  Connection con;
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    
    public static Connection getConnection(){
        try {
            con = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            System.out.println(e.getMessage());     
        }
        return con;
    }
    
}
