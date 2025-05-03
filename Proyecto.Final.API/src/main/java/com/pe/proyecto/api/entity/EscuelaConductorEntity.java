package com.pe.proyecto.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "EscuelaConductorEntity")
@Table(name = "ESCUELAS_CONDUCTORES")
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

	/*private String NOM_DEP;
	private String NOM_PRO ;
	private String NOM_DIS ;*/
	
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
	private Integer eliminado ;

	public EscuelaConductorEntity()
	{
		super();
	}
	public EscuelaConductorEntity(String COD_DEP, String COD_PRO,String COD_DIS, String NRO_RUC, String nombre_Establecimiento, String direccion,String correo,String telefono, String estado)
	{
		setCOD_DEP(COD_DEP);
		setCOD_PRO(COD_PRO);
		setCOD_DIS(COD_DIS);
		setNRO_RUC(NRO_RUC);
		setNombre_Establecimiento(nombre_Establecimiento);
		setDireccion(direccion);
		setCorreo(correo);
		setTelefono(telefono);
		setEstado(estado);
	}
	
	
	public EscuelaConductorEntity(int id, String COD_DEP, String COD_PRO,String COD_DIS, String NRO_RUC, String nombre_Establecimiento, String direccion,String correo,String telefono, String estado)
	{
		setId(id);
		setCOD_DEP(COD_DEP);
		setCOD_PRO(COD_PRO);
		setCOD_DIS(COD_DIS);
		setNRO_RUC(NRO_RUC);
		setNombre_Establecimiento(nombre_Establecimiento);
		setDireccion(direccion);
		setCorreo(correo);
		setTelefono(telefono);
		setEstado(estado);
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCOD_DEP() {
		return COD_DEP;
	}

	public void setCOD_DEP(String COD_DEP) {
		this.COD_DEP = COD_DEP;
	}

	public String getCOD_PRO() {
		return COD_PRO;
	}

	public void setCOD_PRO(String COD_PRO) {
		this.COD_PRO = COD_PRO;
	}

	public String getCOD_DIS() {
		return COD_DIS;
	}

	public void setCOD_DIS(String COD_DIS) {
		this.COD_DIS = COD_DIS;
	}

	
	public String getNRO_RUC() {
		return NRO_RUC;
	}

	public void setNRO_RUC(String NRO_RUC) {
		this.NRO_RUC = NRO_RUC;
	}



	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Integer getEliminado() {
		return eliminado;
	}
	public void setEliminado(Integer eliminado) {
		this.eliminado = eliminado;
	}
	/*public String getNOM_DEP() {
		return NOM_DEP;
	}
	public void setNOM_DEP(String nOM_DEP) {
		NOM_DEP = nOM_DEP;
	}
	public String getNOM_PRO() {
		return NOM_PRO;
	}
	public void setNOM_PRO(String nOM_PRO) {
		NOM_PRO = nOM_PRO;
	}
	public String getNOM_DIS() {
		return NOM_DIS;
	}
	public void setNOM_DIS(String nOM_DIS) {
		NOM_DIS = nOM_DIS;
	}*/
	
	public String getNombre_Establecimiento() {
		return nombre_Establecimiento;
	}

	public void setNombre_Establecimiento(String nombre_Establecimiento) {
		this.nombre_Establecimiento = nombre_Establecimiento;
	}
	
	
	

}
