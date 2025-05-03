package com.pe.proyecto.api_jersey.escuelaConductores.service;

import java.util.List;

import com.pe.proyecto.api_jersey.escuelaConductores.dto.DistritoDto;

public interface DistritoService {

	List<DistritoDto> findNombreLikeCustom(String codigoProvincia, String nombre) throws ServiceException;

}

