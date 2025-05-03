package com.pe.proyecto.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pe.proyecto.api.entity.EscuelaConductorConsultaEntity;
import com.pe.proyecto.api.entity.EscuelaConductorEntity;
import com.pe.proyecto.api.exceptions.DaoException;
import com.pe.proyecto.api.service.EscuelaConductorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/v1/escuelaConductor")
public class EscuelaConductorController {
	private final EscuelaConductorService escuelaConductorService;
	public EscuelaConductorController (EscuelaConductorService escuelaConductorService)
	{
		this.escuelaConductorService = escuelaConductorService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll()throws DaoException 
	{
		List<EscuelaConductorConsultaEntity> departamentos = escuelaConductorService.all();
		return ResponseEntity.ok(departamentos);	
	}
		

    @GetMapping("/{id}")
    public EscuelaConductorConsultaEntity getEscuelaById(@PathVariable Integer id) {
        return escuelaConductorService.findCustomById(id);
    }

    @GetMapping("/buscar")
    public List<EscuelaConductorConsultaEntity> getEscuelasByNombre(@RequestParam String nombre) {
        return escuelaConductorService.findNombreLikeCustom(nombre);
    }

    @GetMapping("/buscar-ubigeo")
    public List<EscuelaConductorConsultaEntity> getEscuelasByUbigeo(@RequestParam String nombre) {
        return escuelaConductorService.findUbigeoLikeCustom(nombre);
    }

    @PostMapping("")
    public EscuelaConductorEntity insertEscuela(@RequestBody EscuelaConductorEntity escuelaConductorEntity) {
        System.out.println("Estamos en el post");
    	return escuelaConductorService.insert(escuelaConductorEntity);
    }
    
    @PutMapping("/{id}")
    public EscuelaConductorEntity updateEscuela(@PathVariable("id") Integer id, @RequestBody EscuelaConductorEntity escuelaConductorEntity) {
        System.out.println("Estamos en el PUT");
        return escuelaConductorService.update(id, escuelaConductorEntity);
    }
    
    @PatchMapping("/{id}")
    public EscuelaConductorEntity patchEscuela(@PathVariable("id") Integer id, @RequestBody EscuelaConductorEntity escuelaConductorEntity) {
        System.out.println("Estamos en el PATCH");
        return escuelaConductorService.update(id, escuelaConductorEntity);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEscuela(@PathVariable("id") Integer id) {
    	try 
    	{
    		Boolean isDeleted = escuelaConductorService.deleteCustom(id);
    		
    		if (isDeleted) {
    			return ResponseEntity.noContent().build(); 
    		} else {
    			return ResponseEntity.status(HttpStatus.NOT_FOUND)
    	                                 .body("Escuela con ID " + id + " no encontrada.");
    		}
    	    } catch (Exception e) {
    	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    	                             .body("Error al intentar eliminar la escuela: " + e.getMessage());
    	    }
    }
	
	
	
}
