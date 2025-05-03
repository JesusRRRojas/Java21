package com.pe.proyecto.api_jersey.escuelaConductores.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DistritoDto {
	private String codigDepartamento;
	private String codigoProvincia;
	private String codigoDistrito;
	private String nombre;
}
