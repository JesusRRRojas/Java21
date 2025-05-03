package com.pe.proyecto.api_jersey.escuelaConductores.mapper;

import com.pe.proyecto.api_jersey.escuelaConductores.dto.DepartamentoDto;
import com.pe.proyecto.api_jersey.escuelaConductores.entity.DepartamentoEntity;


public interface DepartamentoMapper {
	DepartamentoDto toDTO(DepartamentoEntity e);
	DepartamentoEntity toEntity(DepartamentoDto d);
}
