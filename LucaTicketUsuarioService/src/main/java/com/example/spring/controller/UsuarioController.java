package com.example.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Usuario;
import com.example.spring.service.UsuarioService;

@RestController
@RequestMapping 

public class UsuarioController {
	@Autowired
	private UsuarioService serv;

	
	@PostMapping("/usuarios/add")
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		Usuario result = this.serv.save(usuario);
		return result;
	}	
}
