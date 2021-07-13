package com.example.spring;

import static org.hamcrest.CoreMatchers.hasItems;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

import static io.restassured.RestAssured.given;

@SpringBootConfiguration
public class LucaTicketGetUsuariosTest {

	@Test
	public void getEventosTest() {
		given().log().all()
			.port(2222).get("/usuarios")
		.then().log().all()
			.statusCode(200)
			.body("nombre",	hasItems("Godofreo"));
	}

}
