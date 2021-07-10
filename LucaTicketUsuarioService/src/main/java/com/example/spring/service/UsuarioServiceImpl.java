package com.example.spring.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

	@Override
	public Usuario save(Usuario usuario) {
		if (usuario.getNombre() != null && usuario.getApellido() != null && usuario.getContrasenia() != null
				&& usuario.getMail() != null) {
			if (isLetras(usuario.getNombre())) {
				try {
					usuario.setFecha_alta(LocalDateTime.now());
					return this.repo.save(usuario);
				} catch (DataIntegrityViolationException ex) {
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El mail ya existe");
				}
			} else {
				throw new NumeroException();
			}
		} else {
			throw new VacioException();
		}
	}

	public static boolean isLetras(String cadena) {
		for (int x = 0; x < cadena.length(); x++) {
			char c = cadena.charAt(x);
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
				return false;
			}
		}
		return true;
	}
}