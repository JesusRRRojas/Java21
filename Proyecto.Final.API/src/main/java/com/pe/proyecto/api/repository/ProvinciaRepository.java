package com.pe.proyecto.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.proyecto.api.entity.ProvinciaEntity;
import com.pe.proyecto.api.entity.ProvinciaId;

@Repository
public interface ProvinciaRepository extends JpaRepository<ProvinciaEntity, ProvinciaId>{
	
	@Query(value = "SELECT COD_DEP, COD_PRO, NOMBRE FROM PROVINCIAS "
			+ " where COD_DEP = :codigoDepartamento and upper(NOMBRE) like upper(:nombre) ", nativeQuery = true)	
	List<ProvinciaEntity> findNombreLikeCustom( @Param("codigoDepartamento") String codigoDepartamento, @Param("nombre") String nombre);
	
}
