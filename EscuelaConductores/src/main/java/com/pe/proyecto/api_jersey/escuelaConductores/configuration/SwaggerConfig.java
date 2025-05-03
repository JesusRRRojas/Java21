package com.pe.proyecto.api_jersey.escuelaConductores.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Proyecto de Escuela de Conductores")
                .description("Documentación de la API")
                .version("1.0.0"));
    }
}
