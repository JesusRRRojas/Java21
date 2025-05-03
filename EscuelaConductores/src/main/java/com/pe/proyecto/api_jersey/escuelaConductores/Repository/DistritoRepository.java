package com.pe.proyecto.api_jersey.escuelaConductores.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.proyecto.api_jersey.escuelaConductores.entity.DistritoEntity;
import com.pe.proyecto.api_jersey.escuelaConductores.entity.id.DistritoId;

@Repository
public interface DistritoRepository extends JpaRepository<DistritoEntity, DistritoId>{
	
	@Query(value = "SELECT COD_DEP, COD_PRO, COD_DIS, NOMBRE FROM DISTRITOS"
			+ " where COD_PRO = :codigoProvincia and upper(NOMBRE) like upper(:nombre) ", nativeQuery = true)	
	List<DistritoEntity> findNombreLikeCustom( @Param("codigoProvincia") String codigoProvincia, @Param("nombre") String nombre);
	
}
