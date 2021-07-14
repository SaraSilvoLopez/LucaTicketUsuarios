package com.example.spring;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

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
public class LucaTicketGetUsuariosTest {
	
	private static final Logger logger = Logger.getLogger("LucaTicketGetUsuariosTest.class");

	@Test
	public void getUsuariosTest() {
		
		logger.info("---- Se ha invocado el LucaticketGetUsuariosTest");
		given().log().all()
			.port(2222).get("/")
		.then().log().all()
			.statusCode(200)
			.body("nombre",	hasItems("Topacio"));
	}

}
