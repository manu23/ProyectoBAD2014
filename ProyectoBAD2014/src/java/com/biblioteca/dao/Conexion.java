/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Manuel
 */
public class Conexion {
    private Connection conn;
    private final String login="biblioteca";
    private final String password="biblioteca";
    private String url="jdbc:oracle:thin:@localhost:1521:orcl";
    
    public Connection getConexion(){
    try{                
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url,login,password);
        
            
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();;
        }catch(SQLException ex){
            ex.printStackTrace();
        }catch(Exception ex) {
        System.out.println("No se puede conectar a la BD");
        }
        return conn;
    }
    
}
