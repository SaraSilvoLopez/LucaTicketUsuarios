package com.example.spring.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName Usuario
 *
 * @author Patricia Garcia y Usoa larrarte
 *
 * @date 14 jul. 2021
 * 
 * @version 1.0
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDto {

	private String nombre;
	private String apellido;
	private String mail;
	private String contrasenia;
	private LocalDateTime fecha_alta;
	private String rol;

}
