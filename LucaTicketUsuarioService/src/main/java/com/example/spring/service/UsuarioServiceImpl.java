package com.example.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return repo.save(usuario);
	}
}
