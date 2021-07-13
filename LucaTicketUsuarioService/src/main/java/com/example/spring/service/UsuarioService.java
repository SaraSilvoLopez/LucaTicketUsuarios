package com.example.spring.service;

import java.util.List;
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
	
	public List<Usuario> findAll();
	
	public Optional<Usuario> edit(Usuario usuario);
	
	public void deleteById(int id);

}