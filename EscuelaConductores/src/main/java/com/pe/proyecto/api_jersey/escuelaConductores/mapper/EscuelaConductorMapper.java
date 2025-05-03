package com.pe.proyecto.api_jersey.escuelaConductores.mapper;

import com.pe.proyecto.api_jersey.escuelaConductores.dto.EscuelaConductorDto;
import com.pe.proyecto.api_jersey.escuelaConductores.entity.EscuelaConductorConsultaEntity;
import com.pe.proyecto.api_jersey.escuelaConductores.entity.EscuelaConductorEntity;

public interface EscuelaConductorMapper {
	EscuelaConductorDto toDTO(EscuelaConductorConsultaEntity e);
	EscuelaConductorDto toDTO(EscuelaConductorEntity e);
	EscuelaConductorEntity toEntity(EscuelaConductorDto d);
	
}
