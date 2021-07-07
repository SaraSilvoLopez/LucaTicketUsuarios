package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Usuario;
import com.example.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	
	
	@Override
	public Usuario save(Usuario usuario) {
		return repo.save(usuario);
	}

/*	@Override
	public Usuario addUsuario(Usuario usuario) {
		return repo.addUsuario(usuario);
	}
	*/

}
