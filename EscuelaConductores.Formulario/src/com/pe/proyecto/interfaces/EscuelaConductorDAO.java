/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.proyecto.interfaces;

import com.pe.proyecto.bean.EscuelaConductor;
import com.pe.proyecto.bean.Response;
import java.util.List;

/**
 *
 * @author miche
 */
public interface EscuelaConductorDAO extends GenericoDAO<EscuelaConductor> {
        Response Validaciones(EscuelaConductor obj) throws Exception;
        EscuelaConductor BuscarPorId(int Id) throws Exception;
}