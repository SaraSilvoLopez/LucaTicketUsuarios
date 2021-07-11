package com.example.spring.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.spring.exception.EmailExistente;
import com.example.spring.exception.NumeroException;
import com.example.spring.exception.VacioException;
import com.example.spring.model.Usuario;
import com.example.spring.repository.UsuarioRepository;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName UsuarioServiceImpl
 *
 * @author Jennifer Pérez
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {

	/**
	 * Atributo repo
	 * 
	 * 
	 */

	@Autowired
	private UsuarioRepository repo;

	/**
	 * Implementación/Sobrescritura del método save
	 *
	 * @param usuario
	 * @return
	 */
	// Pienso en las cosas que puede hacer mal un usuario para introducir sus datos
	// y crear
	// su usuario en la plataforma o en la BBDD. Puede meter dejar algún campo
	// vacío,
	// puede meter números en el nombre o puede poner un email que ya exista en la
	// BBDD.
	// Son los 3 errores que voy a controlar.
	@Override
	public Usuario save(Usuario usuario) {
		// Le estoy diciendo que el nombre, apellido, contraseña y mail del usuario no
		// pueden estar vacíos.
		if (usuario.getNombre() != null && usuario.getApellido() != null && usuario.getContrasenia() != null
				&& usuario.getMail() != null) {
			if (contieneSoloLetras(usuario.getNombre())) {// Si todos los carácteres del nombre son letras,
				// entonces que haga el try.
				try {// Que continúe poniendo la fecha en la que está haciendo la petición.
					usuario.setFecha_alta(LocalDateTime.now());
					return this.repo.save(usuario); // Que guarda el usuario.
					// Si esto no pasa o da algún error, que entre en el catch.
				} catch (DataIntegrityViolationException ex) { // ex: es el objeto.
					// DataIntegrityViolationException: captura todos los errores que te puede dar
					// la base de datos. Como un traductor de errores de la BBDD a Json.
					throw new EmailExistente();
					//Que ejecute la clase de la excepción EmailExistente.
				}
			} else {
				//Si no pasa lo anterior, que ejecute la clase de la excepción NumeroException.
				throw new NumeroException();
			}
		} else {
			//Si no pasa lo anterior, que ejecute la clase de la excepción VacioException.
			throw new VacioException();
		}
	}

	// He sacado este método de aquí, asegura que el String contenga solamente letras:
	// https://parzibyte.me/blog/2020/02/26/java-cadena-tiene-solo-letras/
	public static boolean contieneSoloLetras(String cadena) {
		for (int x = 0; x < cadena.length(); x++) {//Recorre todo el String
			char c = cadena.charAt(x);//Convierte la letra que le toque en esa vuelta a char.
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
				//Comprueba si ese char no es igual de la a 'a' a la 'z' tanto en mayúsculas 
				//como minúsculas, porque si es diferente de la a a la z, retorna un false,
				// y ya no ejecuta nada más.
				return false;
			}
		}
		//Si todas son letras, retorna true.
		return true;
	}
}