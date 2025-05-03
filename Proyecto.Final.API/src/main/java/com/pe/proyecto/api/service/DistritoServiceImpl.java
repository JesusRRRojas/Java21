package com.pe.proyecto.api.service;

import static java.util.Objects.isNull;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pe.proyecto.api.entity.DistritoEntity;
import com.pe.proyecto.api.repository.DistritoRepository;

@Service
public class DistritoServiceImpl implements DistritoService {

	private final DistritoRepository distritoRepository;
	
	public DistritoServiceImpl(DistritoRepository distritoRepository)
	{
		this.distritoRepository = distritoRepository;
	}

	@Override
	public List<DistritoEntity> findNombreLikeCustom(String codigoProvincia, String nombre) {
		try	
		{
			nombre = "%" + (isNull(nombre) ? "" : nombre) + "%";
			return this.distritoRepository.findNombreLikeCustom(codigoProvincia, nombre);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}
	

}
