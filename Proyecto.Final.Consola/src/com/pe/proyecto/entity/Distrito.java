package com.pe.proyecto.entity;

public class Distrito {
	private String codigoDepartamento;
	private String codigoProvincia;
	private String codigoDistrito;
	private String nombreDistrito;
	
	public Distrito (String codigoDepartamento, String codigoProvincia, String codigoDistrito, String nombreDistrito)
	{
		setCodigoDepartamento(codigoDepartamento);
		setCodigoProvincia(codigoProvincia);
		setCodigoDistrito(codigoDistrito);
		setNombreDistrito(nombreDistrito);
		
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
