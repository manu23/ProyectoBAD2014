/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biblioteca.dao;

import com.biblioteca.dao.impl.TipoArticuloDataSource;
import com.biblioteca.entidades.TipoArticulo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Manuel
 */
public class Conexion {
    private Connection conn;
    private final String login="biblioteca";
    private final String password="biblioteca";
    private String url="jdbc:oracle:thin:@localhost:1521:xe";
    
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
    
    public TipoArticuloDataSource consultarTipoArticulo(int tipo) throws SQLException{
        
        TipoArticuloDataSource datasource = new TipoArticuloDataSource();
        ResultSet rs=getCrearConsulta(tipo);
            
        while(rs.next()){
            TipoArticulo ta = new TipoArticulo(rs.getString("CODIGO"), rs.getString("AUTOR"), rs.getString("TITULO"),
                    rs.getString("DESCRIPCIONART"), rs.getFloat("PRECIO"), isDonado(rs.getInt("DONADO")), rs.getString("IDIOMA"), getFechaString(rs.getDate("FECHAADQUISICION")));
          
            datasource.addTipoArticulo(ta);
        }
        
        return datasource;
    }
    
    public String isDonado(int status){
        String statusString;
        
        if(status==1)
            statusString ="Si";
        else
            statusString ="No";
        
        return statusString;
    }
    
    public String getFechaString(Date fecha){
        String fechString="";
        
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MMM/yy");
        
        if(fecha!=null)
            fechString=formatoFecha.format(fecha);
        
        return fechString;
    }
    
    public ResultSet getCrearConsulta(int tipo) throws SQLException{
        
        Statement s = getConexion().createStatement();
        ResultSet rs=null;
        
        switch(tipo){
            case 1: rs = s.executeQuery("SELECT * FROM ARTICULO ORDER BY AUTOR,TITULO");
                    break;
            case 2: rs = s.executeQuery("SELECT * FROM LIBRO ORDER BY AUTOR,TITULO");
                    break;
            case 3: rs = s.executeQuery("SELECT * FROM REVISTA ORDER BY AUTOR,TITULO");
                    break;
            case 4: rs = s.executeQuery("SELECT * FROM CD ORDER BY AUTOR,TITULO");
                    break;
            case 5: rs = s.executeQuery("SELECT * FROM DVD ORDER BY AUTOR,TITULO");
                    break;
            case 6: rs = s.executeQuery("SELECT * FROM TESIS ORDER BY AUTOR,TITULO");
                    break;
            case 7: rs = s.executeQuery("SELECT * FROM PERIODICOS ORDER BY AUTOR,TITULO");
                    break;
            case 8: rs = s.executeQuery("SELECT * FROM OBRAS ORDER BY AUTOR,TITULO");
                    break;
            case 9: rs = s.executeQuery("SELECT * FROM MEMORIAS ORDER BY AUTOR,TITULO");
                    break;
            default: rs = null;
        }
        
        return rs;
    }
    
}
