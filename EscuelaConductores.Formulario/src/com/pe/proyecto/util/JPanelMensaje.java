/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.proyecto.util;

import javax.swing.JOptionPane;

/**
 *
 * @author Jesus Rojas
 */
public class JPanelMensaje {
    
    public void Succes(String texto){
        JOptionPane.showMessageDialog(null,"Completado: " + texto );
    }
        
    public void Error(String texto){
        JOptionPane.showMessageDialog(null,"Ocurrio el siguiente error : "+ texto );
    }
    public void Alert(String texto){
        JOptionPane.showMessageDialog(null, "Alerta : " + texto);
    
    }
    
    public void Debug(String texto){
        //  Revisando errores
        System.out.println("============================================");
        System.out.println("                Consulta SQL :              ");
        System.out.println("============================================");
        System.out.println(texto);
        System.out.println("============================================");         
    }
}
