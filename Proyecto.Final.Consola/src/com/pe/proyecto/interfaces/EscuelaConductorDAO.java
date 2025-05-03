package com.pe.proyecto.interfaces;

import java.util.List;

import com.pe.proyecto.entity.EscuelaConductor;
import com.pe.proyecto.exception.DAOException;

public interface EscuelaConductorDAO extends GenericoDAO<EscuelaConductor> {
	List<EscuelaConductor> listar(String nombre, Integer opcion) throws DAOException;
}
