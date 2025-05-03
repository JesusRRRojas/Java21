/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.proyecto.bean;

/**
 *
 * @author miche
 */
public class Provincia {
    	private String codigoDepartamento ;
	private String codigoProvincia ;
	private String nombreProvincia ;
	
	public Provincia(String codigoDepartamento , String codigoProvincia, String nombreProvincia)
	{
		this.codigoDepartamento = codigoDepartamento;
		this.codigoProvincia = codigoProvincia;
		this.nombreProvincia=nombreProvincia;
	}
	
	public String getCodigoDepartamento() {
		return codigoDepartamento;
	}
	public void setCodigoDepartamento(String codigoDepartamento) {
		this.codigoDepartamento = codigoDepartamento;
	}
	public String getCodigoProvincia() {
		return codigoProvincia;
	}
	public void setCodigoProvincia(String codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	@Override
	public String toString() {
		return "Provincia [codigoDepartamento=" + codigoDepartamento + ", codigoProvincia=" + codigoProvincia
				+ ", nombreProvincia=" + nombreProvincia + "]";
	}
}
