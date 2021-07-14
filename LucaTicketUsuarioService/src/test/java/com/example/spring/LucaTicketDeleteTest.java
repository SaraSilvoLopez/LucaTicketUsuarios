package com.example.spring;

import static io.restassured.RestAssured.given;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

import io.restassured.http.ContentType;

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
public class LucaTicketDeleteTest {
	
	private static final Logger logger = Logger.getLogger("LucaTicketDeleteTest.class");

		@Test
		public void deleteEventoTest() {
			
			logger.info("---- Se ha invocado el LucaTicketDeleteTest");
			
			given().log().all()
			.port(2222)
			.header("Content-type", "application/json")
			.and()
			.body("{\"id\":\"140\",\"nombre\":\"Luis\", \"apellido\":\"Ramirez\", \"mail\":\"raiheaaz@gmail.com\", \"contrasenia\":\"oefa\" }")
			.when()
			.post("/usuarios/add");
		
			given().log().all()
				.port(2222)
				.accept(ContentType.JSON)
				.delete("/usuarios/delete/140")
			.then().log().all()
				.statusCode(200);
		}
	

}
