package com.pe.proyecto.api.service;

import static java.util.Objects.isNull;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pe.proyecto.api.entity.ProvinciaEntity;
import com.pe.proyecto.api.repository.ProvinciaRepository;


@Service
public class ProvinciaServiceImpl implements ProvinciaService {

	private final ProvinciaRepository provinciaRepository;
	
	public ProvinciaServiceImpl(ProvinciaRepository provinciaRepository)
	{
		this.provinciaRepository = provinciaRepository;
	}

	@Override
	public List<ProvinciaEntity> findNombreLikeCustom(String codigoDepartamento, String nombre) {
		try	
		{
			nombre = "%" + (isNull(nombre) ? "" : nombre) + "%";
			return this.provinciaRepository.findNombreLikeCustom(codigoDepartamento, nombre);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}
	

}
