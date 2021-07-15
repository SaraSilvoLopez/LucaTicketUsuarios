package com.example.spring.controller;

import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;
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
	private static final Logger logger = Logger.getLogger("UsuarioController.class");
	
	/**
	 * Inicializa UsuarioService serv
	 */
	
	@Autowired
	private UsuarioService serv;
	
	/**
	 * Guarda el usuario en la base de datos y devuelve estado de la petición
	 */
	@PostMapping("/usuarios/add")
	public ResponseEntity<String> addUsuario(@RequestBody Usuario usuario) {
		logger.info("---- Se ha invocado el microservicio USUARIOS/ADD");
		Usuario nuevoUsuario = this.serv.save(usuario);
		return new ResponseEntity<>("El usuario se ha guardado correctamente \n" + nuevoUsuario.toString()
		,HttpStatus.CREATED );
	}
	
	
	@RequestMapping("/greeting")
	public String greeting() {
		logger.info("---- Se ha invocado el microservicio USUARIOS/GREETING");
		return "greeting";
	}
	
	@RequestMapping("/greetingAdmin")
	public String greetingAdmin(){
		logger.info("---- Se ha invocado el microservicio USUARIOS/GREETINGADMIN");
		
		return "greeting Admin";
	}
	@GetMapping
	public Collection<Usuario> findAll() {
		logger.info("---- Se ha invocado el microservicio USUARIOS/FINDALL");
		return serv.findAll();
	}
	
	@GetMapping("/usuarios/{id}")
	public Optional<Usuario> findById(@PathVariable int id) {
		logger.info("---- Se ha invocado el microservicio USUARIOS/FINDBYID");
		return serv.findById(id);
	}
	
	@PutMapping("/usuarios/edit")
    public ResponseEntity<String> editUsuario(@RequestBody Usuario usuario) {
		logger.info("---- Se ha invocado el microservicio USUARIOS/EDITUSUARIO");
		Usuario nuevoUsuario = this.serv.edit(usuario);
        return new ResponseEntity<> ("El usuario se ha actualizado correctamente \n" + nuevoUsuario.toString(), HttpStatus.OK);
    }
	
	@DeleteMapping("/usuarios/delete/{id}")
	public ResponseEntity<String> deleteUsuario(@PathVariable int id) {
		logger.info("---- Se ha invocado el microservicio USUARIOS/DELETEUSUARIO");
		serv.deleteById(id);
		return new ResponseEntity<> ("El usuario ha sido borrado correctamente \n", HttpStatus.OK);
	}
}