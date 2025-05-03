package com.pe.proyecto.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pe.proyecto.api.entity.EscuelaConductorConsultaEntity;
import com.pe.proyecto.api.entity.EscuelaConductorEntity;
import com.pe.proyecto.api.entity.EscuelaConductorEntity;

public interface EscuelaConductorRepository extends JpaRepository<EscuelaConductorEntity, Integer>{

	 
	 
/*		@Query(value = "UPDATE "
				+ " ELIMINADO = 1 "
				+ " FROM ESCUELAS_CONDUCTORES ES "
				+ " WHERE  ES.ID = :id ", nativeQuery = true)	
		Boolean deleteCustom(@Param("id") Integer id);
*/
}
