package com.pe.proyecto.api.controller;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping
	public String demo() {
		return "Servicios REST v2 "+LocalDateTime.now();
	}
	
}
