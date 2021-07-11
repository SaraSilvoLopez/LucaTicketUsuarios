package com.example.spring.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.spring.exception.DemasiadosCaracteres;
import com.example.spring.exception.EmailExistenteException;
import com.example.spring.exception.TipoCaracteresException;
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
	 * Instancia UsuarioRepository repo
	 */

	@Autowired
	private UsuarioRepository repo;

	/**
	 * Implementación/Sobrescritura del método save
	 * Con la estructura if
	 *
	 * @param usuario
	 * @return
	 */
	
	@Override
	public Usuario save(Usuario usuario) {
		
		if (usuario.getNombre() != null 
				&& usuario.getApellido() != null 
				&& usuario.getContrasenia() != null
				&& usuario.getMail() != null) {
			if (usuario.getNombre().length() <= 50 
					&& usuario.getApellido().length() <= 50 
					&& usuario.getContrasenia().length() <=50 
					&& usuario.getMail().length() <=50) {
				if (contieneSoloLetras(usuario.getNombre()) 
						&& contieneSoloLetras(usuario.getApellido())) {
					
					try {
						usuario.setFecha_alta(LocalDateTime.now());
						return this.repo.save(usuario); 
					} catch (DataIntegrityViolationException ex) { 
						throw new EmailExistenteException();						
					}
				} else {					
					throw new TipoCaracteresException();
				}
			} else {
				throw new DemasiadosCaracteres();
			}
		} else {
			
			throw new VacioException();
		}
	}

	
	public static boolean contieneSoloLetras(String cadena) {
		for (int x = 0; x < cadena.length(); x++) {
			char c = cadena.charAt(x);
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
				return false;
			}
		}
		return true;
	}
	
}