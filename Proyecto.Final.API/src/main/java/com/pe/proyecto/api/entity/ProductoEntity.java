package com.pe.proyecto.api.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity(name = "ProductoEntity")
@Table(name = "tbl_producto")
public class ProductoEntity {

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProducto")
    @SequenceGenerator(sequenceName = "SEQ_PRODUCTO", allocationSize = 1, name = "seqProducto")
	@Column(name = "producto_id")
	private Long id;

	@Column(name = "nombre",nullable = false,length = 120)
	private String nombre;

	private Double precio;

	private Integer cantidadMinima;

	private Integer cantidadActual;

	private Integer cantidadMaxima;

	private LocalDate fechaRegistro;
	
	private String estado;
	
	
	public ProductoEntity() {
		super();
	}

	public ProductoEntity(Long id, String nombre, Double precio, Integer cantidadActual) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadActual = cantidadActual;
	}


	public ProductoEntity(Long id, String nombre, Double precio, Integer cantidadMinima, Integer cantidadActual,
			Integer cantidadMaxima, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidadMinima = cantidadMinima;
		this.cantidadActual = cantidadActual;
		this.cantidadMaxima = cantidadMaxima;
		this.fechaRegistro = LocalDate.now();
		this.estado = estado;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Integer getCantidadMinima() {
		return cantidadMinima;
	}


	public void setCantidadMinima(Integer cantidadMinima) {
		this.cantidadMinima = cantidadMinima;
	}


	public Integer getCantidadActual() {
		return cantidadActual;
	}


	public void setCantidadActual(Integer cantidadActual) {
		this.cantidadActual = cantidadActual;
	}


	public Integer getCantidadMaxima() {
		return cantidadMaxima;
	}


	public void setCantidadMaxima(Integer cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}


	public LocalDate getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(LocalDate fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", cantidadMinima=" + cantidadMinima
				+ ", cantidadActual=" + cantidadActual + ", cantidadMaxima=" + cantidadMaxima + ", fechaRegistro="
				+ fechaRegistro + ", estado=" + estado + "]";
	}
	
}
