package com.pe.proyecto.api_jersey.escuelaConductores.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EscuelaConductorEntity")
@Table(name = "ESCUELAS_CONDUCTORES")
@Data
public class EscuelaConductorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "COD_DEP")
	private String COD_DEP;
	@Column(name = "COD_PRO")
	private String COD_PRO;
	@Column(name = "COD_DIS")
	private String COD_DIS ;

	@Column(name = "NRO_RUC")
	private String NRO_RUC ;
	@Column(name = "NOMBRE_ESTABLECIMIENTO")
	private String nombre_Establecimiento;
	@Column(name = "DIRECCION")
	private String direccion ;
	@Column(name = "CORREO")
	private String correo ;
	@Column(name = "TELEFONO")
	private String telefono ;
	@Column(name = "ESTADO")
	private String estado ;
	
	@Column(name = "ELIMINADO")
	private Integer eliminado = 0 ;

}
