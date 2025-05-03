package com.pe.proyecto.api_jersey.escuelaConductores.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.Produces;

@Path("/prueba")  // Define la ruta base de la API en Jersey
public class PruebaController {

    @GET
    @Path("/saludo")  // Define la ruta específica para este método
    @Produces(MediaType.TEXT_PLAIN)  // Indica el tipo de respuesta
    public Response saludo() {
        return Response.ok("¡Jersey está funcionando en Spring Boot!").build();
    }
}