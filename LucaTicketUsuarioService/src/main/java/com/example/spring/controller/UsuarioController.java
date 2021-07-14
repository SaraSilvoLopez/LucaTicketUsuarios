package com.example.spring.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	 * Inicializa UsuarioService serv
	 */
	@Autowired
	private UsuarioService serv;

	
	/**
	 * Guarda el usuario en la base de datos y devuelve estado de la peticion
	 */
	@PostMapping("/usuarios/add")
	public ResponseEntity<String> addUsuario(@RequestBody Usuario usuario) {
		Usuario nuevoUsuario = this.serv.save(usuario);
		return new ResponseEntity<>("El usuario se ha guardado correctamente \n" + nuevoUsuario.toString()
		,HttpStatus.CREATED );
	}
	
	
	@RequestMapping("/greeting")
	public String greeting() {
		
		return "greeting";
	}
	
	@RequestMapping("/greetingAdmin")
	public String greetingAdmin(){
		
		return "greeting Admin";
	}
	@GetMapping
	public Collection<Usuario> mostrarUsuarios() {
		return serv.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> mostrarUsuario(@PathVariable int id) {
		return serv.findById(id);
	}
	
	@PutMapping("/usuarios/edit")
    public Optional<Usuario> editUsuario(@RequestBody Usuario usuario) {
        return this.serv.edit(usuario);
    }
	
	@DeleteMapping("/usuarios/delete/{id}")
	public void deleteUsuario(@PathVariable int id) {
		serv.deleteById(id);
	}

}