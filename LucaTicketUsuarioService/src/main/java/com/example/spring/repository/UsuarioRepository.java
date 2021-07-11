package com.example.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Usuario;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName UsuarioRepository
 *
 * @author Jennifer Pérez y Sara Silvo
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
