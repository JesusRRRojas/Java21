package com.pe.proyecto.api_jersey.escuelaConductores.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProvinciaDto {
	private String codigoDepartamento;
	private String codigoProvincia;
	private String nombre;
}
