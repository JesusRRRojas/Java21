/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.proyecto.bean;

/**
 *
 * @author miche
 */
public class Distrito {
    	private String codigoDepartamento;
	private String codigoProvincia;
	private String codigoDistrito;
	private String nombreDistrito;
	
	public Distrito (String codigoDepartamento, String codigoProvincia, String codigoDistrito, String nombreDistrito)
	{
		this.codigoDepartamento = codigoDepartamento;
		this.codigoProvincia = codigoProvincia;
		this.codigoDistrito = codigoDistrito;
		this.nombreDistrito = nombreDistrito;
		
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
	public String getCodigoDistrito() {
		return codigoDistrito;
	}
	public void setCodigoDistrito(String codigoDistrito) {
		this.codigoDistrito = codigoDistrito;
	}
	public String getNombreDistrito() {
		return nombreDistrito;
	}
	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}
	@Override
	public String toString() {
		return "Distrito [codigoDepartamento=" + codigoDepartamento + ", codigoProvincia=" + codigoProvincia
				+ ", codigoDistrito=" + codigoDistrito + ", nombreDistrito=" + nombreDistrito + "]";
	}
	
}
