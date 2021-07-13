package com.example.spring;



import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;



import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootConfiguration;



@SpringBootConfiguration
public class LucaticketGetUsuarioTest {



@Test
public void getUsuarioTest() {
given().log().all()
.port(2222).get("/2")
.then().log().all()
.statusCode(200).body("id", is(2));
}


}