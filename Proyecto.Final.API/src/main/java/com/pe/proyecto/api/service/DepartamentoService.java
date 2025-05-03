package com.pe.proyecto.api.service;

import java.util.List;

import com.pe.proyecto.api.entity.DepartamentoEntity;

public interface DepartamentoService {

	List<DepartamentoEntity> findNombreLikeCustom(String nombre);

}
