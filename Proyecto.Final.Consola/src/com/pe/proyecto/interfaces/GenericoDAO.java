package com.pe.proyecto.interfaces;

import java.util.List;

import com.pe.proyecto.exception.DAOException;

public interface GenericoDAO<T> {

	List<T> listar(String nombre) throws DAOException;
	
	Boolean insertar(T producto) throws DAOException;
	
	Boolean actualizar(T producto) throws DAOException;

	Boolean eliminar(Long id) throws DAOException;
	
}
