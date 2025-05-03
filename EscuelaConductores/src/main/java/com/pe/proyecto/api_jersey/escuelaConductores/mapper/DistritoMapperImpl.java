package com.pe.proyecto.api_jersey.escuelaConductores.mapper;

import org.springframework.stereotype.Component;

import com.pe.proyecto.api_jersey.escuelaConductores.dto.DistritoDto;
import com.pe.proyecto.api_jersey.escuelaConductores.entity.DistritoEntity;

@Component
public class DistritoMapperImpl implements DistritoMapper {

	@Override
	public DistritoDto toDTO(DistritoEntity e) {
		return DistritoDto
				.builder()
				.codigDepartamento(e.getID().getCOD_DEP())
				.codigoDistrito(e.getID().getCOD_DIS())
				.codigoProvincia(e.getID().getCOD_PRO())
				.nombre(e.getNOMBRE())
				.build();
	}

}
