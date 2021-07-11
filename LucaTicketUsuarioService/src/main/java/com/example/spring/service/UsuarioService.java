package com.example.spring.service;

import java.util.Optional;

import com.example.spring.model.Usuario;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName UsuarioService
 *
 * @author Jennifer Pérez y Sara Silvo
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */

public interface UsuarioService {
	

	public Usuario save(Usuario usuario);
	
	public Optional<Usuario> findByMail(String mail);
	
	public Optional<Usuario> findById(int id);

}
