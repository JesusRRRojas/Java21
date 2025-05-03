package com.pe.proyecto.api_jersey.escuelaConductores.entity;

import jakarta.persistence.Column;
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
@Entity(name = "DepartamentoEntity")
@Table(name = "DEPARTAMENTOS")
@Data
public class DepartamentoEntity {
	
	@Id
	@Column(name = "COD_DEP")
	private String COD_DEP ;
	@Column(name = "NOMBRE")
	private String NOMBRE ;
	
	/*
	public DepartamentoEntity()
	{
		super();
	}
	
	public DepartamentoEntity(String cod_dep, String nombre ) 
	{
		this.COD_DEP = cod_dep;
		this.NOMBRE = nombre;		
	}	*/
	public String getCOD_DEP() {
		return COD_DEP;
	}
	public void setCOD_DEP(String cOD_DEP) {
		this.COD_DEP = cOD_DEP;
	}
	public String getNOMBRE() {
		return NOMBRE;
	}
	public void setNOMBRE(String nOMBRE) {
		this.NOMBRE = nOMBRE;
	}
	@Override
	public String toString() {
		return "DepartamentoEntity [COD_DEP=" + this.COD_DEP + ", NOMBRE=" + this.NOMBRE + "]";
	}



	
}
