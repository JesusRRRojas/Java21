package com.pe.proyecto.api_jersey.escuelaConductores.mapper;

import org.springframework.stereotype.Component;

import com.pe.proyecto.api_jersey.escuelaConductores.dto.DepartamentoDto;
import com.pe.proyecto.api_jersey.escuelaConductores.entity.DepartamentoEntity;

@Component
public class DepartamentomapperImpl implements DepartamentoMapper{

	@Override
	public DepartamentoDto toDTO(DepartamentoEntity e) {
		return DepartamentoDto
				.builder()
				.codigoDepartamento(e.getCOD_DEP())
				.nombre(e.getNOMBRE())
				.build();
	}

	@Override
	public DepartamentoEntity toEntity(DepartamentoDto d) {
		return DepartamentoEntity
				.builder()
				.COD_DEP(d.getCodigoDepartamento())
				.NOMBRE(d.getNombre())
				.build();
	}

}
