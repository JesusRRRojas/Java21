package com.pe.proyecto.api.service;

import java.util.List;
import java.util.Optional;

import com.pe.proyecto.api.entity.ProductoEntity;

public interface ProductoService {

	//List<ProductoEntity> getAll();
	
	List<ProductoEntity> findByNombre(String nombre); 
	
	Optional<ProductoEntity> findById(Long id);
	
	ProductoEntity save(ProductoEntity productoEntity);
	
	ProductoEntity update(Long id, ProductoEntity productoEntity); 
		
	void delete(Long id);
	
}