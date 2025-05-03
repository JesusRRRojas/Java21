package com.pe.proyecto.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.proyecto.api.entity.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
	
	// 01
	// Generate by JPA
	List<ProductoEntity> findByNombreLike(String nombre);

	// JPQL -Java Persistence query language

	// 02
	@Query("select p from ProductoEntity p where upper(nombre) like upper(:nombre) and estado='1'")
	List<ProductoEntity> findByNombreLikeCustom(@Param("nombre") String nombre);
	
	// SQL Native
	
	// 03
	@Query(value = "select id, nombre,precio,cantidad_minima,"
			+ " cantidad_maxima,cantidad_actual,fecha_registro,estado from tbl_producto"
			+ " where upper(nombre) like upper(:nombre) and estado='1'", nativeQuery = true)	
	List<ProductoEntity> listarSQL(@Param("nombre") String nombre);
	
	// 04 
	// USP
	
}
