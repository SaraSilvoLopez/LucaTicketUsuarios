package com.example.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.model.Usuario;
import com.example.spring.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository repo;
	
	
	@Override
	public Usuario save(Usuario usuario) {
		return repo.save(usuario);
	}
}
