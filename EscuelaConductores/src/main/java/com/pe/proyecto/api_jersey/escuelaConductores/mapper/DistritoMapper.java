package com.pe.proyecto.api_jersey.escuelaConductores.mapper;

import com.pe.proyecto.api_jersey.escuelaConductores.dto.DistritoDto;
import com.pe.proyecto.api_jersey.escuelaConductores.entity.DistritoEntity;

public interface DistritoMapper {
	DistritoDto toDTO(DistritoEntity e);
}
