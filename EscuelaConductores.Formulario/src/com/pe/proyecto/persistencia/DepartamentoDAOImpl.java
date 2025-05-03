/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.proyecto.persistencia;

import com.pe.proyecto.bean.Departamento;
import com.pe.proyecto.interfaces.DepartamentoDAO;
import com.pe.proyecto.util.Conexion;
import com.pe.proyecto.util.JPanelMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miche
 */
public class DepartamentoDAOImpl extends Conexion implements DepartamentoDAO {
    JPanelMensaje JPanel = new JPanelMensaje();
    @Override
    public List<Departamento> listarTodos() throws Exception {
        List<Departamento> departamentos = new ArrayList<Departamento>();
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            this.ConexionOpen();
            
            String Query = "SELECT COD_DEP, NOMBRE FROM DEPARTAMENTOS";
                    
            ps = this.conexion.prepareStatement(Query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Departamento depa = new Departamento();
                depa.setCodigoDepartamento(rs.getString("COD_DEP"));    
                depa.setNombreDepartamento(rs.getString("NOMBRE"));

                departamentos.add((depa));
            }
            
            
        } catch (Exception e) {
            JPanel.Error(e.getMessage());
            e.printStackTrace();
            throw e;
        } 
        
        return departamentos;
			
			
    }

    @Override
    public List<Departamento> listarPorNombre(String nombre) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean insertar(Departamento T) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean actualizar(Departamento T) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
