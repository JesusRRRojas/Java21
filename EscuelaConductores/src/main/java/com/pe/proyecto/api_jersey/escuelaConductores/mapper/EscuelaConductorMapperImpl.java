package com.pe.proyecto.api_jersey.escuelaConductores.mapper;

import org.springframework.stereotype.Component;

import com.pe.proyecto.api_jersey.escuelaConductores.dto.EscuelaConductorDto;
import com.pe.proyecto.api_jersey.escuelaConductores.entity.EscuelaConductorConsultaEntity;
import com.pe.proyecto.api_jersey.escuelaConductores.entity.EscuelaConductorEntity;

@Component
public class EscuelaConductorMapperImpl implements EscuelaConductorMapper {

	@Override
	public EscuelaConductorDto toDTO(EscuelaConductorConsultaEntity e) {
		return EscuelaConductorDto
				.builder()
				.codigoDepartamento(e.getCOD_DEP())
				.nombreDepartamento(e.getNOM_DEP())
				.codigoDistrito(e.getCOD_DIS())
				.nombreDistrito(e.getNOM_DIS())
				.codigoProvincia(e.getCOD_PRO())
				.nombreProvincia(e.getNOM_PRO())
				.nroRUC(e.getNRO_RUC())
				.nombreEscuela(e.getNombre_Establecimiento())
				.direccion(e.getDireccion())
				.correo(e.getCorreo())
				.telefono(e.getTelefono())
				.estado(e.getEstado())
				.id(e.getId())
				.build();
	}
	
	@Override
	public EscuelaConductorDto toDTO(EscuelaConductorEntity e) {
		return EscuelaConductorDto
				.builder()
				.codigoDepartamento(e.getCOD_DEP())
				.codigoDistrito(e.getCOD_DIS())
				.codigoProvincia(e.getCOD_PRO())
				.nroRUC(e.getNRO_RUC())
				.nombreEscuela(e.getNombre_Establecimiento())
				.direccion(e.getDireccion())
				.correo(e.getCorreo())
				.telefono(e.getTelefono())
				.estado(e.getEstado())
				.id(e.getId())
				.build();
	}
	@Override
	public EscuelaConductorEntity toEntity(EscuelaConductorDto d) {
		return EscuelaConductorEntity
				.builder()
				.id(d.getId())
				.COD_DEP(d.getCodigoDepartamento())
				.COD_PRO(d.getCodigoProvincia())
				.COD_DIS(d.getCodigoDistrito())
				.correo(d.getCorreo())
				.direccion(d.getDireccion())
				.estado(d.getEstado())
				.nombre_Establecimiento(d.getNombreEscuela())
				.NRO_RUC(d.getNroRUC())
				.telefono(d.getTelefono())
				.build();
	}



}
