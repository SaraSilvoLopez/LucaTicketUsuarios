package com.example.spring;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

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
public class LucaticketGetUsuarioTest {

	private static final Logger logger = Logger.getLogger("LucaTicketGetUsuarioTest.class");

	
	@Test
	public void getUsuarioTest() {
		
		logger.info("---- Se ha invocado el LucaticketGetUsuarioTest");
		
		given().log().all()
			.port(2222).get("/2")
		.then().log().all()
			.statusCode(200).body("id", is(2));
	}


}