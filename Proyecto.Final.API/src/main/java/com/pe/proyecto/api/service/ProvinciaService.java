package com.pe.proyecto.api.service;

import java.util.List;

import com.pe.proyecto.api.entity.ProvinciaEntity;

public interface ProvinciaService {

	List<ProvinciaEntity> findNombreLikeCustom(String codigoDepartamento, String nombre);

}
