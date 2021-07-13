package com.example.spring.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.example.spring.model.Usuario;
import com.example.spring.repository.UsuarioRepository;
import com.example.spring.service.UsuarioService;
import com.example.spring.service.UsuarioServiceImpl;


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
	 * Inicializa UsuarioService sev
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
	
	
	/**
	 * Método para listar todos los usuarios de la BBDDs
	 * 
	 * @return List<Usuario>
	 */
	@GetMapping
	public List<Usuario> getUsuarios() {
		
		return serv.findAll();
	}
	/*
	@GetMapping("/usuarios/{id}")
	public Usuario getUsuario(@PathVariable int id) {
		return serv.findById(id).orElseThrow(UsuarioNotFoundException::new);
	}*/
	
	@DeleteMapping("/usuarios/delete/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable("id") int id) {
		
		try {
			if (serv.findById(id).isPresent()) {
				serv.deleteById(id);
				return ResponseEntity.ok().build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/usuarios/update")
	public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario) {
		
		try {
			if (serv.findById(usuario.getId()).isPresent()) {
				Usuario usuarioModificado = serv.save(usuario);
				URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
						.buildAndExpand(usuarioModificado.getId()).toUri();
				return ResponseEntity.created(location).build();
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
		}
	}
	
	
	
	
	@RequestMapping("/greeting")
	public String greeting() {
		
		return "greeting";
	}
	
	@RequestMapping("/greetingAdmin")
	public String greetingAdmin() {
		
		return "greeting Admin";
	}

}
