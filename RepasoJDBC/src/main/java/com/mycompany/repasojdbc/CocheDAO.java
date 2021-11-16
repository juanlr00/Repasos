/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.repasojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Coche;

/**
 *
 * @author JuanLamasRubio
 */
public class CocheDAO {
    
     private static Connection connection;
    
    static{
        String url = "jdbc:mysql://localhost:3306/repasojdbc?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "";
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida con la base de datos");
        } catch (SQLException ex) {
            System.out.println("Error en la conexión");
            System.out.println(ex);
        }
    }
    
//    static final String LIST_QUERY ="SELECT * FROM tarea";
    static final String INSERT_SQL = "INSERT INTO `coche` (`modelo`, `matricula`)" + " VALUES (?, ?)";
    static final String SELECT_SQL = "SELECT * FROM coche"; 
    static final String QUERY_SQL = "SELECT * FROM coche WHERE modelo = ?";
//    static final String GET_QUERY= "SELECT * FROM tarea WHERE id=?";
//    static final String REMOVE_QUERY="DELETE FROM tarea WHERE id=?";
//    static final String COUNT_QUERY="SELECT count(id) as total from tarea";
    
    public void add(Coche c) {
       try {
           PreparedStatement ps = connection.prepareStatement(INSERT_SQL,RETURN_GENERATED_KEYS);
           ps.setString(1, c.getModelo());
           ps.setString(2, c.getMatricula());
           ps.executeUpdate();
           
           ResultSet ids = ps.getGeneratedKeys();
           ids.next();
           c.setId( (long)(ids.getInt(1)) );
           System.out.println(c);
       } catch (Exception ex) {
           System.out.println("Error al añadir");
           System.out.println(ex);
       }
    }
    
    public ArrayList<Coche> List() {
        
        ArrayList<Coche> salida = new ArrayList<Coche>();
        
         try {
             Statement q = connection.createStatement();
             ResultSet rs = q.executeQuery(SELECT_SQL);
             
             while(rs.next()) {
                 Coche c = new Coche();
                 c.setId( rs.getLong(1));
                 c.setModelo( rs.getString("modelo"));
                 c.setMatricula( rs.getString("matricula"));
                 salida.add(c);
             }
         } catch (Exception ex) {
             System.out.println("Error al leer");
             System.out.println(ex);
         }
         return salida;
    }
    
    public ArrayList<Coche> listTesla() {
        
         ArrayList<Coche> salida = new ArrayList<Coche>();
        
         try {
             PreparedStatement q = connection.prepareStatement(QUERY_SQL);
             q.setString(1, "Tesla");
             ResultSet rs = q.executeQuery();
             
             while(rs.next()) {
                 Coche c = new Coche();
                 c.setId( rs.getLong(1));
                 c.setModelo( rs.getString("modelo"));
                 c.setMatricula( rs.getString("matricula"));
                 salida.add(c);
             }
         } catch (SQLException ex) {
             System.out.println("Error al leer");
             System.out.println(ex);
         }
         return salida;
    }
    
}
