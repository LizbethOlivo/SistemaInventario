/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author user name
 */
public class Conexion {
     
    private final String base= "inventario";
    private final String user="root";
    private final String password="";
    private final String url="jdbc:mysql://localhost:3306/"+base;
    private Connection con= null;
    public Connection getConexion() throws ClassNotFoundException
    {
    try {
     Class.forName("com.mysql.cj.jdbc.Driver");
     con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
    
    }catch(SQLException e)
    {
      System.err.println(e);
     
    }    
    return con;
    
    
    }      
}
