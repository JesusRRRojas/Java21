package com.pe.proyecto.api_jersey.escuelaConductores.service;
import java.util.List;

import com.pe.proyecto.api_jersey.escuelaConductores.dto.DepartamentoDto;

public interface DepartamentoService {
	List<DepartamentoDto> findNombreLikeCustom(String nombre) throws ServiceException;
	DepartamentoDto Agregar(DepartamentoDto dto) throws ServiceException;
	DepartamentoDto findById(String codDepartamento)throws ServiceException;
}
