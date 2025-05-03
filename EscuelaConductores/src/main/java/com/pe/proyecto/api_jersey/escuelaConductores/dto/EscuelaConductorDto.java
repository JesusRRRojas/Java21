package com.pe.proyecto.api_jersey.escuelaConductores.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EscuelaConductorDto {
	private Integer id;
	private String codigoDepartamento;
	private String codigoProvincia;
	private String codigoDistrito;
	private String nombreDepartamento;
	private String nombreProvincia;
	private String nombreDistrito;
	private String nroRUC ;
	private String nombreEscuela;
	private String direccion ;
	private String correo ;
	private String telefono ;
	private String estado ;

}
