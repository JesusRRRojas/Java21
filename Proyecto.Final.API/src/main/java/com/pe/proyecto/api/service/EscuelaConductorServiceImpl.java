package com.pe.proyecto.api.service;

import static java.util.Objects.isNull;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pe.proyecto.api.entity.EscuelaConductorConsultaEntity;
import com.pe.proyecto.api.entity.EscuelaConductorEntity;
import com.pe.proyecto.api.repository.EscuelaConductorConsultasRepository;
import com.pe.proyecto.api.repository.EscuelaConductorRepository;

@Service
public class EscuelaConductorServiceImpl implements EscuelaConductorService {

	private final EscuelaConductorRepository escuelaConductorRepository;
	private final EscuelaConductorConsultasRepository escuelaConductorConsultasRepository;
	
	public EscuelaConductorServiceImpl(EscuelaConductorRepository escuelaConductorRepository, EscuelaConductorConsultasRepository escuelaConductorConsultasRepository)
	{
		this.escuelaConductorRepository = escuelaConductorRepository;
		this.escuelaConductorConsultasRepository = escuelaConductorConsultasRepository;
	}
	
	@Override
	public List<EscuelaConductorConsultaEntity> all() {
		try	
		{
			return this.escuelaConductorConsultasRepository.all(); 
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}

	@Override
	public EscuelaConductorConsultaEntity findCustomById(Integer id) {
		try	
		{
			return this.escuelaConductorConsultasRepository.findCustomById(id);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}

	@Override
	public List<EscuelaConductorConsultaEntity> findNombreLikeCustom(String nombre) {
		try	
		{
			nombre = "%" + (isNull(nombre) ? "" : nombre) + "%";
			return this.escuelaConductorConsultasRepository.findNombreLikeCustom(nombre);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}

	@Override
	public List<EscuelaConductorConsultaEntity> findUbigeoLikeCustom(String nombre) {
		try	
		{
			nombre = "%" + (isNull(nombre) ? "" : nombre) + "%";
			return this.escuelaConductorConsultasRepository.findUbigeoLikeCustom(nombre);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}
	
	@Override
	public Optional<EscuelaConductorEntity> findById(Integer id) {
		try	
		{
			return this.escuelaConductorRepository.findById(id);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}

	@Override
	public EscuelaConductorEntity insert(EscuelaConductorEntity escuelaConductorEntity) {
		try	
		{
			escuelaConductorEntity.setEliminado(0);
			return this.escuelaConductorRepository.save(escuelaConductorEntity);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}

	@Override
	public EscuelaConductorEntity update(Integer id, EscuelaConductorEntity updateEntity) {
		try	
		{
			
			Optional<EscuelaConductorEntity> buscarEscuela = findById(id) ;
			EscuelaConductorEntity oOriginal = buscarEscuela.get();
			
					
			if(updateEntity.getCOD_DEP() != null)
				oOriginal.setCOD_DEP(updateEntity.getCOD_DEP());
			
			if(updateEntity.getCOD_PRO() != null)
				oOriginal.setCOD_PRO(updateEntity.getCOD_PRO());
			
			if(updateEntity.getCOD_DIS() != null)
				oOriginal.setCOD_DIS(updateEntity.getCOD_DIS());
			
			if(updateEntity.getNRO_RUC() != null)
				oOriginal.setNRO_RUC(updateEntity.getNRO_RUC());
			
			if(updateEntity.getNombre_Establecimiento() != null)
				oOriginal.setNombre_Establecimiento(updateEntity.getNombre_Establecimiento());
			
			if(updateEntity.getDireccion() != null)
				oOriginal.setDireccion(updateEntity.getDireccion());
			
			if(updateEntity.getCorreo() != null)
				oOriginal.setCorreo(updateEntity.getCorreo());
			
			if(updateEntity.getTelefono() != null)
				oOriginal.setTelefono(updateEntity.getTelefono());
			
			if(updateEntity.getEstado() != null)
				oOriginal.setEstado(updateEntity.getEstado());
			
			
			return this.escuelaConductorRepository.save(oOriginal);
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}
	@Override
	public Boolean deleteCustom(Integer id) {
		try	
		{
			Optional<EscuelaConductorEntity> buscarEscuela = findById(id) ;
			EscuelaConductorEntity oOriginal = buscarEscuela.get();
			
			oOriginal.setEliminado(1); 
			
			var escuelaEliminado = this.escuelaConductorRepository.save(oOriginal);
			return escuelaEliminado != null;
		}
		catch(Exception e)
		{
			throw new RuntimeException();
		}
	}

}
