package com.example.spring.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByMail(String mail);

	@Modifying
	@Query("update Usuario u set u.nombre = ?1, u.apellido = ?2,u.mail = ?4, u.contrasenia = ?5  where u.id = ?3  ")
	void editar(String nombre, String apellido, int id, String mail, String contrasenia);

}
