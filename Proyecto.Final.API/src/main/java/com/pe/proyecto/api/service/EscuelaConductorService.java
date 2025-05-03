package com.pe.proyecto.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.pe.proyecto.api.entity.EscuelaConductorConsultaEntity;
import com.pe.proyecto.api.entity.EscuelaConductorEntity;

public interface EscuelaConductorService {
	List<EscuelaConductorConsultaEntity> all();
	EscuelaConductorConsultaEntity findCustomById(@Param("id") Integer id);
	List<EscuelaConductorConsultaEntity> findNombreLikeCustom(@Param("nombre") String nombre);
	List<EscuelaConductorConsultaEntity> findUbigeoLikeCustom(@Param("nombre") String nombre);
	Optional<EscuelaConductorEntity> findById(Integer id);
	EscuelaConductorEntity insert(EscuelaConductorEntity escuelaConductorEntity);
	EscuelaConductorEntity update(Integer id, EscuelaConductorEntity escuelaConductorEntity);
	Boolean deleteCustom(Integer id);

}
