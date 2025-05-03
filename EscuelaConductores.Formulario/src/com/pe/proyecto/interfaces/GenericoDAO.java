/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.proyecto.interfaces;

import java.util.List;

/**
 *
 * @author miche
 */
public interface GenericoDAO<T> {
    List<T> listarTodos() throws Exception;
    List<T> listarPorNombre(String nombre) throws Exception;
    Boolean insertar(T T) throws Exception;
    Boolean actualizar(T T) throws Exception;
    Boolean eliminar(int id) throws Exception;
    
}
