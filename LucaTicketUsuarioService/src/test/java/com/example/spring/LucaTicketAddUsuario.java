package com.example.spring;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.spring.controller.UsuarioController;
import com.example.spring.model.Usuario;
import com.example.spring.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName LucaTicketAddUsuario
 *
 * @author Jennifer Perez y Sara Silvo
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(UsuarioController.class)
public class LucaTicketAddUsuario {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UsuarioService serv;

	@Autowired
	ObjectMapper mapper;

	@Test
	void addUsuarioTest1() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setNombre("Pedro");
		usuario.setApellido("Blasco");
		usuario.setMail("blasco@gmail.com");
		usuario.setContrasenia("ieo20");
		LocalDateTime Date = LocalDateTime.parse("2021-07-07");
		usuario.setFecha_alta(Date);

		Mockito.when(serv.save(usuario)).thenReturn(usuario);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/usuarios/add")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(usuario));

		mockMvc.perform(mockRequest).andExpect(status().isOk())
		.andExpect(jsonPath("$", notNullValue()))
		.andExpect(jsonPath("$.nombre", is("Pedro")))
		.andExpect(jsonPath("$.apellido", is("Blasco")))
		.andExpect(jsonPath("$.mail", is("blasco@gmail.com")))
		.andExpect(jsonPath("$.contrasenia", is("ieo20")))
		.andExpect(jsonPath("$.fecha_alta", is("2021/07/07")))
		;

	}
	
	@Test
	void addUsuarioTest2() throws Exception {

		Usuario usuario = new Usuario();

		Mockito.when(serv.save(usuario)).thenReturn(usuario);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/usuarios/add")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(usuario));

		mockMvc.perform(mockRequest).andExpect(status().isOk())
		.andExpect(jsonPath("$", notNullValue()))
		.andExpect(jsonPath("$.id", is(0)));
		;

	}
	

}