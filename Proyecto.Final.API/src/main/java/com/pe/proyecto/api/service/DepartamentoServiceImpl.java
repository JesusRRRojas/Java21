package com.pe.proyecto.api.service;

import static java.util.Objects.isNull;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pe.proyecto.api.entity.DepartamentoEntity;
import com.pe.proyecto.api.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

	private final DepartamentoRepository departamentoRepository;
	
	public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository)
	{
		this.departamentoRepository = departamentoRepository;
	}

	@Override
	public List<DepartamentoEntity> findNombreLikeCustom(String nombre) {
		System.out.println(nombre);
		try	
		{
			nombre = "%" + (isNull(nombre) ? "" : nombre) + "%";
			return this.departamentoRepository.findNombreLikeCustom(nombre);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}
	

}
