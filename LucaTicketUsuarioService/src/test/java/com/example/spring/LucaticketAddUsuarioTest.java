package com.example.spring;
import static io.restassured.RestAssured.given;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName UsuarioController
 *
 * @author Jennifer Pérez y Sara Silvo
 *
 * @date 14 jul. 2021
 * 
 * @version 1.0
 */

@SpringBootConfiguration
public class LucaticketAddUsuarioTest {
	
	private static final Logger logger = Logger.getLogger("LucaTicketAddUsuario.class");

		@Test
		public void postRequest() {
			
			logger.info("---- Se ha invocado el LucaticketAddUsuarioTest");
			
			given()
				.port(2222)
				.header("Content-type", "application/json")
				.and()
				.body("{\"nombre\":\"Luis\", \"apellido\":\"Ramirez\", \"mail\":\"sssnoestarepetido@gmail.com\", \"contrasenia\":\"oefa\"}")
			.when()
				.post("/usuarios/add")
			.then().log().all()
				.statusCode(201);
		 }
	
}