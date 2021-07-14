package com.example.spring;

import static io.restassured.RestAssured.given;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

/**
 * @Project LucaTicketEventoService
 *
 * @ClassName LucaTicketEditUsuarioTest
 *
 * @author  Jennifer Pérez y Sara Silvo
 *
 * @date 13 jul. 2021
 *
 * @version 1.0
 */

@SpringBootConfiguration
public class LucaTicketEditUsuarioTest {

	private static final Logger logger = Logger.getLogger("LucaTicketEditUsuarioTest.class");

	@Test
	public void editEventoTest() {

		logger.info("---- Se ha invocado el EditEventoTest");

		given().log().all().port(2222).header("Content-type", "application/json").and().body(
				"{\"id\":\"190\", \"nombre\":\"Maria\", \"apellido\":\"Minas\", \"mail\":\"rrffarfrrr@gdmail.com\", \"contrasenia\":\"456\"}")
				.when().post("/usuarios/add");

		given().log().all().port(2222).header("Content-type", "application/json").and().body(
				"{\"id\":\"190\", \"nombre\":\"Maria\", \"apellido\":\"Minos\", \"mail\":\"rrffarfrrr@gdmail.com\", \"contrasenia\":\"456\"}")
				.when().put("/usuarios/edit").then().log().all().statusCode(200);
	}
}