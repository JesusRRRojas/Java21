package com.pe.proyecto.api_jersey.escuelaConductores.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;

import com.pe.proyecto.api_jersey.escuelaConductores.controller.EscuelaConductorController;
import com.pe.proyecto.api_jersey.escuelaConductores.controller.ParametroController;
import com.pe.proyecto.api_jersey.escuelaConductores.controller.PruebaController;

import jakarta.ws.rs.ApplicationPath;

@Configuration
@ApplicationPath("/api")
public class JerseyConfiguration extends ResourceConfig {
	
	public JerseyConfiguration()
	{
		//packages("com.pe.proyecto.api_jersey.escuelaConductores.Controller");
		//register(org.glassfish.jersey.server.spring.SpringComponentProvider.class);
		   
		register(PruebaController.class);
		register(ParametroController.class);
		register(EscuelaConductorController.class);
		register(CorsConfig.class);
	}
}
