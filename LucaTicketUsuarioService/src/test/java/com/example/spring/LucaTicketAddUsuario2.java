package com.example.spring;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.example.spring.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UsuarioController.class)
public class LucaTicketAddUsuario2 {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UsuarioRepository repo;

	@Autowired
	ObjectMapper mapper;

	@Test
	void addUsuarioTest1() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setNombre("Pedro");
		usuario.setApellido("Blasco");
		usuario.setMail("blasco@gmail.com");
		usuario.setContrasenia("ieo20");
		usuario.setFecha_alta("2021/07/07");

		Mockito.when(repo.save(usuario)).thenReturn(usuario);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/usuarios/add")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(this.mapper.writeValueAsString(usuario));

		mockMvc.perform(mockRequest).andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.nombre", is("Pedro")));

	}

}