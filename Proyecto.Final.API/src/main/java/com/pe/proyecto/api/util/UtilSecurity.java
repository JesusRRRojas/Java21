package com.pe.proyecto.api.util;

import static java.util.Objects.isNull;
import java.util.Base64;

import com.pe.proyecto.api.dto.UserDTO;
import com.pe.proyecto.api.exceptions.UserException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilSecurity {

	public static UserDTO getUser(String authorization) throws UserException {
		log.info("Authorization => {}", authorization);
		if (isNull(authorization)) {
			throw new UserException("Authorization null");
		}

		if (authorization.trim().length() <= 6) {
			throw new UserException("Authorization legth, not valid");
		}
		String dataEncode = authorization.substring(6);

		log.info("dataEncode => {}", dataEncode);

		byte[] dataBytes = Base64.getDecoder().decode(dataEncode);
		String dataString = new String(dataBytes);

		String dataArray[] = dataString.split(":");
		
		if (dataArray.length!=2) {
			throw new UserException("Authorization array not valid");
		}

		log.info("User => {}", dataArray[0]);
		log.info("Clave => {}", dataArray[1]);

		return new UserDTO(dataArray[0], dataArray[1]);
	}

}
