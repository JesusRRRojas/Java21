package com.pe.proyecto.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pe.proyecto.api.entity.DepartamentoEntity;

@Repository
public interface DepartamentoRepository extends JpaRepository<DepartamentoEntity, String>{
	
	// Método que Spring Data JPA generará automáticamente
    //List<DepartamentoEntity> findByNombreDepartamentoLike();
	
	@Query(value = "select COD_DEP, NOMBRE from DEPARTAMENTOS", nativeQuery = true)	
	List<DepartamentoEntity> findNombreLikeCustom2(String nombre);

	@Query(value = "select COD_DEP, NOMBRE from DEPARTAMENTOS"
			+ " where upper(NOMBRE) like upper(:nombre) ", nativeQuery = true)	
	List<DepartamentoEntity> findNombreLikeCustom(@Param("nombre") String nombre);
	
}
