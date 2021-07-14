package com.example.spring.security;

import javax.validation.Valid;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Usuario;

import lombok.RequiredArgsConstructor;

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

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider tokenProvider;
	
	@PostMapping("/usuarios/login")
	public JwtUsuarioRespuesta login(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = 
				authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginRequest.getMail(),
							loginRequest.getContrasenia()
							
						)							
				);
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		Usuario usuario = (Usuario) authentication.getPrincipal();
		String jwtToken = tokenProvider.generateToken(authentication);
		
		return convertUserEntityAndTokenToJwtUserResponse(usuario, jwtToken);
				
	}
	
	private JwtUsuarioRespuesta convertUserEntityAndTokenToJwtUserResponse(Usuario usuario, String jwtToken) {
		return JwtUsuarioRespuesta
				.jwtUsuarioRespuestaBuilder()
				.nombre(usuario.getNombre())
				.apellido(usuario.getApellido())
				.mail(usuario.getMail())
				.contrasenia(usuario.getContrasenia())
				.fecha_alta(usuario.getFecha_alta())			
				.rol(usuario.getRol())
				.token(jwtToken)
				.build();
		
	}
}
