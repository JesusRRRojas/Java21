package com.pe.proyecto.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.pe.proyecto.api.dto.UserDTO;
import com.pe.proyecto.api.exceptions.UserException;
import com.pe.proyecto.api.util.UtilSecurity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BaseController {

	
	@Value("${seg.user.name}")
	private String user;
	
	@Value("${seg.user.password}")
	private String password;

	protected ResponseEntity<?> authorization(String authorization) throws UserException {
		
		log.info("user => {}",user);
		
		log.info("password => {}",password);
	
		UserDTO userDTO=UtilSecurity.getUser(authorization);
	
		if (!(userDTO.user().equals(user) && userDTO.password().equals(password) )) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		return ResponseEntity.ok().build();
		
	}
}
