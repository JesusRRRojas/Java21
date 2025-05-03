package com.pe.proyecto.api_jersey.escuelaConductores.service;
import static java.util.Objects.isNull;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.pe.proyecto.api_jersey.escuelaConductores.Repository.DistritoRepository;
import com.pe.proyecto.api_jersey.escuelaConductores.dto.DistritoDto;
import com.pe.proyecto.api_jersey.escuelaConductores.mapper.DistritoMapper;


@Service
public class DistritoServiceImpl implements DistritoService {

	@Autowired
	private DistritoRepository distritoRepository;
	
	@Autowired
	private DistritoMapper distritoMapper;
	
	
	@Override
	public List<DistritoDto> findNombreLikeCustom(String codigoProvincia, String nombre) throws ServiceException {
		nombre = "%" + (isNull(nombre) ? "" : nombre) + "%";
		return distritoRepository.findNombreLikeCustom(codigoProvincia, nombre).stream().map(d-> distritoMapper.toDTO(d)).toList();

	}


}
