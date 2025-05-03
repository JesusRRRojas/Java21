package com.pe.proyecto.api_jersey.escuelaConductores.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EscuelaConductorFullEntity")
@Table(name = "ESCUELAS_CONDUCTORES")
@Data
public class EscuelaConductorConsultaEntity {
	
	@Id
	private int id;


	private String COD_DEP;

	private String COD_PRO;

	private String COD_DIS ;

	private String NOM_DEP;
	private String NOM_PRO ;
	private String NOM_DIS ;


	private String NRO_RUC ;

	private String nombre_Establecimiento;

	private String direccion ;

	private String correo ;

	private String telefono ;

	private String estado ;

	
	
	
}
