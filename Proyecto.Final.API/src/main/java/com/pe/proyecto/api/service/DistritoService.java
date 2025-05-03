package com.pe.proyecto.api.service;

import java.util.List;

import com.pe.proyecto.api.entity.DepartamentoEntity;
import com.pe.proyecto.api.entity.DistritoEntity;

public interface DistritoService {

	List<DistritoEntity> findNombreLikeCustom(String codigoProvincia, String nombre);

}
