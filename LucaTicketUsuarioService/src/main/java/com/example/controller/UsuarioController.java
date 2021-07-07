package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Usuario;
import com.example.service.UsuarioService;

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
	
	/*@PostMapping(value = "/register")
	public String addUsuario(Usuario usuario, BindingResult bindingResult, Model model) {
		Usuario userExists = serv.findUsuarioByNombre(usuario.getNombre());
		if (userExists != null) {
			model.addAttribute("message", "Username already registered");
			return "register";
		} else {
			serv.save(usuario);
			model.addAttribute("message", "Successful registration. Please login");
			return "login";
		}
	}
*/
	
}
