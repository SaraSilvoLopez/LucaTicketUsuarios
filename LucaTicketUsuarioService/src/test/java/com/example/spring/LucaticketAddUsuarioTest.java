package com.example.spring;
import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
public class LucaticketAddUsuarioTest {

		@Test
		public void postRequest() {
			
						
			given()
				.port(2222)
				.header("Content-type", "application/json")
				.and()
				.body("{\"nombre\":\"Luis\", \"apellido\":\"Ramirez\", \"mail\":\"ramrez@gmail.com\", \"contrasenia\":\"oefa\",  \"rol\": \"USER\" }")
			.when()
				.post("/usuarios/add")
			.then().log().all()
				.statusCode(201);
		 }
	
}