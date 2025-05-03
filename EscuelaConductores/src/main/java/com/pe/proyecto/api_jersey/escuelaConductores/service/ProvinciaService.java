package com.pe.proyecto.api_jersey.escuelaConductores.service;

import java.util.List;

import com.pe.proyecto.api_jersey.escuelaConductores.dto.ProvinciaDto;

public interface ProvinciaService {

	List<ProvinciaDto> findNombreLikeCustom(String codigoDepartamento, String nombre) throws ServiceException;

	ProvinciaDto findById(String codDepartamento, String codProvincia) throws ServiceException;
	//ProvinciaDto Agregar(ProvinciaDto dto) throws ServiceException;

}
