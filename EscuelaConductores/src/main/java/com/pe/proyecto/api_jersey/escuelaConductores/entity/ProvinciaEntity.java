package com.pe.proyecto.api_jersey.escuelaConductores.entity;

import com.pe.proyecto.api_jersey.escuelaConductores.entity.id.ProvinciaId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ProvinciaEntity")
@Table(name = "PROVINCIAS")
@Data
public class ProvinciaEntity {
	@EmbeddedId
	private ProvinciaId ID;
	
	@Column(name = "NOMBRE")
	private String NOMBRE;

	
	/*public ProvinciaEntity()
	{
		super();
	}
	
	public ProvinciaEntity(ProvinciaId id, String nombre)
	{
		setID(id);
		setNOMBRE(nombre);			
	}*/
	
	public ProvinciaId getID() {
		return ID;
	}

	public void setID(ProvinciaId iD) {
		ID = iD;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	@Override
	public String toString() {
		return "ProvinciaEntity [ID=" + ID + ", NOMBRE=" + NOMBRE + "]";
	} 

	
	
	
}
