package com.example.spring.security;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName Usuario
 *
 * @author Patricia Garcia y Usoa Larrarte
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
	
	@NotBlank
	private String mail;
	@NotBlank
	private String contrasenia;

}