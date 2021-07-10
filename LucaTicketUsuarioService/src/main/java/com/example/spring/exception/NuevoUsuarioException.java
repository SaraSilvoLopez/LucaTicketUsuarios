package com.example.spring.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class NuevoUsuarioException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 43876691117560211L;

	
	public NuevoUsuarioException(int id) {
		super("Usuario ya registrado en la Base de Datos: " + id);
	}	
}