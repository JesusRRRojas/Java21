package com.pe.proyecto.api.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pe.proyecto.api.dto.UserDTO;
import com.pe.proyecto.api.entity.ProductoEntity;
import com.pe.proyecto.api.exceptions.UserException;
import com.pe.proyecto.api.service.ProductoService;
import com.pe.proyecto.api.util.UtilSecurity;

import lombok.extern.slf4j.Slf4j;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@RequestMapping("api/v1/productos")
public class ProductoController extends BaseController {

	private final ProductoService productoService;

	// DI -Constructor
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@GetMapping
	public ResponseEntity<?> getAll(@RequestHeader("Authorization") String authorization) throws UserException {

		ResponseEntity<?> rest = super.authorization(authorization);

		if (!rest.getStatusCode().is2xxSuccessful()) {
			return rest;
		}
		List<ProductoEntity> productos = productoService.findByNombre("");
		return ResponseEntity.ok(productos);

	}

	@GetMapping("/productos")
	CollectionModel<EntityModel<ProductoEntity>> all(@RequestHeader("Authorization") String authorization)
			throws UserException {

		ResponseEntity<?> rest = super.authorization(authorization);

		if (!rest.getStatusCode().is2xxSuccessful()) {
			return null;
		}

		List<EntityModel<ProductoEntity>> employees = productoService.findByNombre("").stream().map(producto -> {
			try {
				return EntityModel.of(producto,
						linkTo(methodOn(ProductoController.class).getById(producto.getId(), authorization))
								.withSelfRel(),
						linkTo(methodOn(ProductoController.class).all(authorization)).withRel("productos"));
			} catch (UserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toList());

		return CollectionModel.of(employees,
				linkTo(methodOn(ProductoController.class).all(authorization)).withSelfRel());
	}

	/*
	 * @GetMapping("/{id}") public ProductoEntity getById(@PathVariable Long id) {
	 * return productoService.findById(id).orElse(null); }
	 */

	@GetMapping("/{id}")
	public EntityModel<ProductoEntity> getById(@PathVariable Long id,
			@RequestHeader("Authorization") String authorization) throws UserException {
		ProductoEntity producto = productoService.findById(id).orElse(null);
		return EntityModel.of(producto,
				linkTo(methodOn(ProductoController.class).getById(id, authorization)).withSelfRel(),
				linkTo(methodOn(ProductoController.class).all(authorization)).withRel("employees"));
	}

	@GetMapping("/find-by-nombre")
	public ResponseEntity<?> findByNombre(@RequestParam String nombre,
		@RequestHeader("Authorization") String authorization) throws UserException {
		
		/*
		UserDTO userDTO = UtilSecurity.getUser(authorization);
		if (!(userDTO.user().equals("anovoa") && userDTO.password().equals("123456"))) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}*/
		ResponseEntity<?> rest = super.authorization(authorization);
		if (!rest.getStatusCode().is2xxSuccessful()) {
			return rest;
		}
		return ResponseEntity.ok(productoService.findByNombre(nombre));
	}

	@PostMapping
	public ResponseEntity<?>  save(@RequestBody ProductoEntity productoEntity,@RequestHeader("Authorization") String authorization) throws UserException {
		ResponseEntity<?> rest = super.authorization(authorization);
		if (!rest.getStatusCode().is2xxSuccessful()) {
			return rest;
		}
		return ResponseEntity.ok(productoService.save(productoEntity));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ProductoEntity productoEntity,@RequestHeader("Authorization") String authorization) throws UserException {
		ResponseEntity<?> rest = super.authorization(authorization);
		if (!rest.getStatusCode().is2xxSuccessful()) {
			return rest;
		}
		return ResponseEntity.ok(productoService.update(id, productoEntity));
	}

	@DeleteMapping("/{id}")
	public  ResponseEntity<?> delete(@PathVariable Long id,@RequestHeader("Authorization") String authorization) throws UserException {
		ResponseEntity<?> rest = super.authorization(authorization);
		if (!rest.getStatusCode().is2xxSuccessful()) {
			return rest;
		}
		productoService.delete(id);
		return ResponseEntity.ok().build();
	}

}
