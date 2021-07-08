package com.example.spring.service;

import com.example.spring.model.Usuario;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName UsuarioService
 *
 * @author Jennifer Pérez
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */

public interface UsuarioService {
	
	/**
	 * @param usuario
	 * @return
	 */
	
	public Usuario save(Usuario usuario);

}
