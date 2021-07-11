package com.example.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Usuario;
import com.example.spring.service.UsuarioService;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName UsuarioController
 *
 * @author Jennifer Pérez y Sara Silvo
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */
@RestController
@RequestMapping 
public class UsuarioController {
	/**
	 * Inicializa UsuarioService
	 */
	@Autowired
	private UsuarioService serv;

	
	/**
	 * @param usuario
	 * @return usuario guardado en la base de datos
	 */
	@PostMapping("/usuarios/add")
	public Usuario addUsuario(@RequestBody Usuario usuario) {

		return this.serv.save(usuario);
		
	}
		
}
