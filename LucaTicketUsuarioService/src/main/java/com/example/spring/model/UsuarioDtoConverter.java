package com.example.spring.model;

import org.springframework.stereotype.Component;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName Usuario
 *
 * @author Patricia Garcia y Usoa larrarte
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */

@Component
public class UsuarioDtoConverter {

	public UsuarioDto convertUserEntityToGetUserDto(Usuario usuario) {
		return UsuarioDto.builder().nombre(usuario.getNombre()).apellido(usuario.getApellido()).mail(usuario.getMail())
				.contrasenia(usuario.getContrasenia()).fecha_alta(usuario.getFecha_alta())
				.rol(usuario.getRol().toString()).build();
	}
}
