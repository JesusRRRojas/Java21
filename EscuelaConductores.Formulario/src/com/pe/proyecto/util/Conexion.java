/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.proyecto.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author miche
 */
public class Conexion {
    protected Connection conexion;
    
    private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String DB_URL = "jdbc:oracle:thin:@localhost:1521:FREE";
    private final String USERNAME = "C##BDJROJAS";
    private final String PASSWORD = "123456";
 
    
    public void ConexionOpen() throws Exception {
        try {            
            Class.forName(DRIVER);
            this.conexion = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void ConexionClose() throws SQLException{
        if(this.conexion != null){
            if(!this.conexion.isClosed())
                this.conexion.close();
        }
    }
    
}

