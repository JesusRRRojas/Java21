/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.proyecto.bean;

/**
 *
 * @author miche
 */
public class Departamento {
    	private String codigoDepartamento ;
	private String nombreDepartamento ;

        public Departamento()
	{
	}
	public Departamento(String codigoDepartamento, String nombreDepartamento )
	{
		this.codigoDepartamento = codigoDepartamento;
		this.nombreDepartamento = nombreDepartamento;
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
