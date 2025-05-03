package com.pe.proyecto.api_jersey.escuelaConductores.util;

import static java.util.Objects.isNull;
import java.util.Base64;

import com.pe.proyecto.api_jersey.escuelaConductores.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilSecurity {

	public static UserDto getUser(String authorization) throws Exception {
		log.info("Authorization => {}", authorization);
		if (isNull(authorization)) {
			throw new Exception("Authorization null");
		}

		if (authorization.trim().length() <= 6) {
			throw new Exception("Authorization legth, not valid");
		}
		String dataEncode = authorization.substring(6);

		log.info("dataEncode => {}", dataEncode);

		byte[] dataBytes = Base64.getDecoder().decode(dataEncode);
		String dataString = new String(dataBytes);

		String dataArray[] = dataString.split(":");
		
		if (dataArray.length!=2) {
			throw new Exception("Authorization array not valid");
		}

		log.info("User => {}", dataArray[0]);
		log.info("Clave => {}", dataArray[1]);

		return new UserDto(dataArray[0], dataArray[1]);
	}

}
