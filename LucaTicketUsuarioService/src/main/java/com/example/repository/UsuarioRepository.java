package com.example.repository;
import com.example.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UsuarioRepository
 *
 * @author Jennifer Pérez
 * @date 06 jul. 2021
 * 
 * @version 2.0
 */


@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	//Usuario addUsuario(String nombre);
}
