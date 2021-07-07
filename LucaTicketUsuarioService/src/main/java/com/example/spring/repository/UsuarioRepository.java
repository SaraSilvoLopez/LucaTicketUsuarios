package com.example.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Usuario;

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

}
