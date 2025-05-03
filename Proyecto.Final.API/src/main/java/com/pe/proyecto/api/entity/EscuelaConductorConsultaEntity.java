package com.pe.proyecto.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "EscuelaConductorFullEntity")
@Table(name = "ESCUELAS_CONDUCTORES")
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

	public EscuelaConductorConsultaEntity()
	{
		super();
	}
	public EscuelaConductorConsultaEntity(String COD_DEP, String COD_PRO,String COD_DIS, String NRO_RUC, String nombre_Establecimiento, String direccion,String correo,String telefono, String estado)
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
	
	
	public EscuelaConductorConsultaEntity(int id, String COD_DEP, String COD_PRO,String COD_DIS, String NRO_RUC, String nombre_Establecimiento, String direccion,String correo,String telefono, String estado)
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
	
	public EscuelaConductorConsultaEntity(int id,  String COD_DEP, String nomDepartamento, String COD_PRO, String nomProvincia,String COD_DIS, String nomDistrito, String NRO_RUC, String nombre_Establecimiento, String direccion,String correo,String telefono, String estado)
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
		setNOM_DEP(nomDepartamento);
		setNOM_DIS(nomDistrito);
		setNOM_PRO(nomProvincia);
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

	public String getNOM_DEP() {
		return NOM_DEP;
	}

	public void setNOM_DEP(String NOM_DEP) {
		this.NOM_DEP = NOM_DEP;
	}

	public String getNOM_PRO() {
		return NOM_PRO;
	}

	public void setNOM_PRO(String NOM_PRO) {
		this.NOM_PRO = NOM_PRO;
	}

	public String getNOM_DIS() {
		return NOM_DIS;
	}

	public void setNOM_DIS(String NOM_DIS) {
		this.NOM_DIS = NOM_DIS;
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

	
	
	public String getNombre_Establecimiento() {
		return nombre_Establecimiento;
	}
	public void setNombre_Establecimiento(String nombre_Establecimiento) {
		this.nombre_Establecimiento = nombre_Establecimiento;
	}
	@Override
	public String toString() {
		return "EscuelaConductor [ID = "+ id +" COD_DEP=" + COD_DEP + ", COD_PRO=" + COD_PRO
				+ ", COD_DIS=" + COD_DIS + ", NOM_DEP=" + NOM_DEP + ", NOM_PRO="
				+ NOM_PRO + ", NOM_DIS=" + NOM_DIS + ", NRO_RUC=" + NRO_RUC
				+ ", nombre_Establecimiento=" + nombre_Establecimiento + ", direccion=" + direccion + ", correo=" + correo
				+ ", telefono=" + telefono + ", estado=" + estado + "]";
	}
	
}
