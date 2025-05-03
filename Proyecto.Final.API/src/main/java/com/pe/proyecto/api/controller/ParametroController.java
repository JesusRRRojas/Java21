package com.pe.proyecto.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pe.proyecto.api.entity.DepartamentoEntity;
import com.pe.proyecto.api.entity.DistritoEntity;
import com.pe.proyecto.api.entity.ProductoEntity;
import com.pe.proyecto.api.entity.ProvinciaEntity;
import com.pe.proyecto.api.exceptions.DaoException;
import com.pe.proyecto.api.exceptions.UserException;
import com.pe.proyecto.api.service.DepartamentoService;
import com.pe.proyecto.api.service.DistritoService;
import com.pe.proyecto.api.service.ProvinciaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/parametros")
public class ParametroController extends BaseController {
	private final DepartamentoService departamentoService;
	private final ProvinciaService provinciaService;
	private final DistritoService distritoService;
	
	public ParametroController(DepartamentoService departamentoService, ProvinciaService provinciaService, DistritoService distritoService)
	{
		this.departamentoService = departamentoService;
		this.provinciaService= provinciaService;
		this.distritoService = distritoService;
	}
	
	@GetMapping("/getDepartamentos")
	public ResponseEntity<?> getDepartamento (@RequestParam String nombre)throws DaoException 
	{
		List<DepartamentoEntity> departamentos = departamentoService.findNombreLikeCustom(nombre);
		return ResponseEntity.ok(departamentos);	
	}
	
	@GetMapping("/getProvincias/{codDepartamento}")
	public ResponseEntity<?> getProvincia (@PathVariable("codDepartamento") String codDepartamento, @RequestParam String nombre )throws DaoException 
	{
		List<ProvinciaEntity> provincias = provinciaService.findNombreLikeCustom(codDepartamento, nombre);
		return ResponseEntity.ok(provincias);
	}
		
	@GetMapping("/getDistritos/{codProvincia}")
	public ResponseEntity<?> getDistrito (@PathVariable("codProvincia") String codProvincia, @RequestParam String nombre )throws DaoException 
	{
		List<DistritoEntity> distrito = distritoService.findNombreLikeCustom(codProvincia, nombre);
		return ResponseEntity.ok(distrito);
	}
	
	/*===========================================================*/
	@GetMapping("/getAll")
	public CollectionModel<EntityModel<DepartamentoEntity>> all() throws DaoException {
	    List<EntityModel<DepartamentoEntity>> departamentos = departamentoService.findNombreLikeCustom("").stream()
	        .map(dep -> {

	                // Genera el enlace correctamente pasando el parámetro 'nombre' al método getDepartamento
	                try {
						return EntityModel.of(dep,
						        linkTo(methodOn(ParametroController.class).getDepartamento(dep.getNOMBRE())).withSelfRel());
					} catch (DaoException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;

	        })
	        .collect(Collectors.toList());

	    // Devuelve la colección de departamentos con el enlace de la propia colección
	    return CollectionModel.of(departamentos,
	            linkTo(methodOn(ParametroController.class).getDepartamento("pas")).withSelfRel());
	}


	
}
