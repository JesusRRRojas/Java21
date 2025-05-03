package com.pe.proyecto.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.pe.proyecto.api.entity.ProductoEntity;
import com.pe.proyecto.api.repository.ProductoRepository;

import static java.util.Objects.isNull;
import java.time.LocalDate;

@Service
public class ProductoServiceImpl implements ProductoService {

	private final ProductoRepository productoRepository;

	// DI -Contructor
	public ProductoServiceImpl(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	@Override
	public List<ProductoEntity> findByNombre(String nombre) {
		try {
			nombre = "%" + (isNull(nombre) ? "" : nombre) + "%";
			return this.productoRepository.findByNombreLikeCustom(nombre);
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public Optional<ProductoEntity> findById(Long id) {
		try {
			return this.productoRepository.findById(id);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public ProductoEntity save(ProductoEntity productoEntity) {
		try {
			productoEntity.setFechaRegistro(LocalDate.now());
			productoEntity.setEstado("1");
			return this.productoRepository.save(productoEntity);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public ProductoEntity update(Long id, ProductoEntity productoEntity) {
		try {
			
			Optional<ProductoEntity> optProducto=this.findById(id); 
			
			if (optProducto.isPresent()) {
				
				ProductoEntity prmProductoEntity=optProducto.get();
				prmProductoEntity.setNombre(productoEntity.getNombre());
				prmProductoEntity.setPrecio(productoEntity.getPrecio());
				prmProductoEntity.setCantidadMinima(productoEntity.getCantidadMinima());
				//prmProductoEntity.setCantidadActual(productoEntity.getCantidadActual());
				prmProductoEntity.setCantidadMaxima(productoEntity.getCantidadMaxima());
				
				return this.productoRepository.save(prmProductoEntity);
				
			} else { 
			
				productoEntity.setFechaRegistro(LocalDate.now());
				productoEntity.setEstado("1");
				return this.productoRepository.save(productoEntity);
			}
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Optional<ProductoEntity> optProducto=this.findById(id); 
		
		if (optProducto.isPresent()) {
			ProductoEntity prmProductoEntity=optProducto.get();
			prmProductoEntity.setEstado("0");
			productoRepository.save(prmProductoEntity);
			return;
		}	
		
		throw new RuntimeException("Producto no existe con el id +"+id);
	}

}
