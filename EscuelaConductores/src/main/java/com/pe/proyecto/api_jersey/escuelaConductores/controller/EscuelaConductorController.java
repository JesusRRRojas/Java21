package com.pe.proyecto.api_jersey.escuelaConductores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pe.proyecto.api_jersey.escuelaConductores.dto.EscuelaConductorDto;
import com.pe.proyecto.api_jersey.escuelaConductores.service.EscuelaConductorService;
import com.pe.proyecto.api_jersey.escuelaConductores.service.ServiceException;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/v1/escuelaConductor")
@Produces("application/json")
@Consumes("application/json")
public class EscuelaConductorController {

	@Autowired
	private EscuelaConductorService escuelaConductorService;
		

	@GET
	@Path("getAll")
	public Response getAll()throws ServiceException
	{
		List<EscuelaConductorDto> departamentos = escuelaConductorService.all();
		return Response.ok().entity(departamentos).build();	
	}
			

	@GET
	@Path("/{id}")
	public Response getEscuelaById(@PathParam("id") Integer id)throws ServiceException {
		EscuelaConductorDto escuela =  escuelaConductorService.findCustomById(id);
		if (escuela == null) 
			return Response.noContent().build();

		return Response.ok().entity(escuela).build() ;
	}

	@GET
	@Path("/buscar")
	public List<EscuelaConductorDto> getEscuelasByNombre(@QueryParam("nombre") String nombre)throws ServiceException {
		return escuelaConductorService.findNombreLikeCustom(nombre);
	}

	@GET
	@Path("/buscar-ubigeo")
	public Response getEscuelasByUbigeo(@QueryParam("nombre") String nombre) throws ServiceException{
		List<EscuelaConductorDto> escuelas = escuelaConductorService.findUbigeoLikeCustom(nombre);
		return Response.ok().entity(escuelas).build();
	}
	
	@GET
	@Path("/buscar-filtro/{departamento}/{provincia}/{distrito}")
	public Response getEscuelasByUbigeo(@PathParam("departamento") String departamento,@PathParam("provincia") String provincia, @PathParam("distrito") String distrito ) throws ServiceException{
		System.out.println("==== buscar-filtro ===");
		List<EscuelaConductorDto> escuelas = escuelaConductorService.findFiltro(departamento, provincia, distrito);
		return Response.ok().entity(escuelas).build();
	}

	@POST   
	public Response insertEscuela(EscuelaConductorDto escuelaConductorDto)throws ServiceException {

		
		var rucRegistrado = escuelaConductorService.existeRUC(escuelaConductorDto.getNroRUC());
		 if (rucRegistrado) 
			 return Response.status(Response.Status.CONFLICT)
					 .entity("Ya existe una escuela con el mismo RUC registrado")
                     .build();
		
		EscuelaConductorDto escuela = escuelaConductorService.insert(escuelaConductorDto);
		return Response.ok().entity(escuela).build() ;
    }

	@PUT
	@Path("/{id}")
	public Response updateEscuela(@PathParam("id") Integer id, EscuelaConductorDto escuelaConductorDto)throws ServiceException {
		EscuelaConductorDto escuela = escuelaConductorService.update(id, escuelaConductorDto);
		return Response.ok().entity(escuela).build() ;
	}
	    
	@PATCH
	@Path("/{id}")
	public Response patchEscuela(@PathParam("id") Integer id, EscuelaConductorDto escuelaConductorDto)throws ServiceException {
		EscuelaConductorDto escuela = escuelaConductorService.update(id, escuelaConductorDto);
		return Response.ok().entity(escuela).build() ;
	}
	 
	@DELETE
	@Path("/{id}")
	public Response deleteEscuela(@PathParam("id") Integer id) {
	    try {
	        Boolean isDeleted = escuelaConductorService.deleteCustom(id);

	        if (isDeleted) {
	            return Response.noContent().build(); // 204 No Content
	        } else {
	            return Response.status(Response.Status.NOT_FOUND)
	                    .entity("Escuela con ID " + id + " no encontrada.")
	                    .build();
	        }
	    } catch (Exception e) {
	        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity("Error al intentar eliminar la escuela: " + e.getMessage())
	                .build();
	    }
	}	
}
