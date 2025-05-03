package com.pe.proyecto.entity;

public class EscuelaConductor {

	private int id;

	private String codDepartamento;
	private String codProvincia;
	private String codDistrito ;

	private String nombreDepartamento;
	private String nombreProvincia ;
	private String nombreDistrito ;

	private String nroRUC ;
	private String nombreEstablecimiento;
	private String direccion ;
	private String correo ;
	private String telefono ;
	private String estado ;

	public EscuelaConductor()
	{}
	public EscuelaConductor(String codDepartamento, String codProvincia,String codDistrito, String nroRUC, String nombreEstablecimiento, String direccion,String correo,String telefono, String estado)
	{
		setCodDepartamento(codDepartamento);
		setCodProvincia(codProvincia);
		setCodDistrito(codDistrito);
		setNroRUC(nroRUC);
		setNombreEstablecimiento(nombreEstablecimiento);
		setDireccion(direccion);
		setCorreo(correo);
		setTelefono(telefono);
		setEstado(estado);
	}
	
	
	public EscuelaConductor(int id, String codDepartamento, String codProvincia,String codDistrito, String nroRUC, String nombreEstablecimiento, String direccion,String correo,String telefono, String estado)
	{
		setId(id);
		setCodDepartamento(codDepartamento);
		setCodProvincia(codProvincia);
		setCodDistrito(codDistrito);
		setNroRUC(nroRUC);
		setNombreEstablecimiento(nombreEstablecimiento);
		setDireccion(direccion);
		setCorreo(correo);
		setTelefono(telefono);
		setEstado(estado);
	}
	
	public EscuelaConductor(int id,  String codDepartamento, String nomDepartamento, String codProvincia, String nomProvincia,String codDistrito, String nomDistrito, String nroRUC, String nombreEstablecimiento, String direccion,String correo,String telefono, String estado)
	{
		setId(id);
		setCodDepartamento(codDepartamento);
		setCodProvincia(codProvincia);
		setCodDistrito(codDistrito);
		setNroRUC(nroRUC);
		setNombreEstablecimiento(nombreEstablecimiento);
		setDireccion(direccion);
		setCorreo(correo);
		setTelefono(telefono);
		setEstado(estado);
		setNombreDepartamento(nomDepartamento);
		setNombreDistrito(nomDistrito);
		setNombreProvincia(nomProvincia);
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public String getCodProvincia() {
		return codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}

	public String getCodDistrito() {
		return codDistrito;
	}

	public void setCodDistrito(String codDistrito) {
		this.codDistrito = codDistrito;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public String getNroRUC() {
		return nroRUC;
	}

	public void setNroRUC(String nroRUC) {
		this.nroRUC = nroRUC;
	}

	public String getNombreEstablecimiento() {
		return nombreEstablecimiento;
	}

	public void setNombreEstablecimiento(String nombreEstablecimiento) {
		this.nombreEstablecimiento = nombreEstablecimiento;
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

	@Override
	public String toString() {
		return "EscuelaConductor [ID = "+ id +" codDepartamento=" + codDepartamento + ", codProvincia=" + codProvincia
				+ ", codDistrito=" + codDistrito + ", nombreDepartamento=" + nombreDepartamento + ", nombreProvincia="
				+ nombreProvincia + ", nombreDistrito=" + nombreDistrito + ", nroRUC=" + nroRUC
				+ ", nombreEstablecimiento=" + nombreEstablecimiento + ", direccion=" + direccion + ", correo=" + correo
				+ ", telefono=" + telefono + ", estado=" + estado + "]";
	}
	

}
