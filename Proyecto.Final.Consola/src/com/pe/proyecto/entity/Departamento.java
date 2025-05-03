package com.pe.proyecto.entity;

public class Departamento {
	private String codigoDepartamento ;
	private String nombreDepartamento ;

	public Departamento(String codigoDepartamento, String nombreDepartamento )
	{
		setCodigoDepartamento(codigoDepartamento);
		setNombreDepartamento(nombreDepartamento);
	}
	
	
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombre) {
		this.nombreDepartamento = nombre;
	}

	
	@Override
	public String toString() {
		return "Departamento [codigoDepartamento=" + codigoDepartamento + ", nombre=" + nombreDepartamento + "]";
	}
	
	
}
