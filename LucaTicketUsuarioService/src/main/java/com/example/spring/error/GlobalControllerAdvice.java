package com.example.spring.error;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.spring.exception.DemasiadoLargoException;
import com.example.spring.exception.EmailExistenteException;
import com.example.spring.exception.NumeroException;
import com.example.spring.exception.VacioException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestControllerAdvice
public class GlobalControllerAdvice {
	
	//La anotación @ExceptionHandler se encargará de anotar un método como el 
	//encargado de realizar acciones en caso de que se lance una excepción.
	//handleJasonMappingException, maneja los errores de parseo de valores al crear/editar
	//un usuario (JsonMappingException).
	
	@ExceptionHandler(JsonMappingException.class)
	public ResponseEntity<ApiError> handleJsonMappingException(JsonMappingException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
		
	@ExceptionHandler(NumeroException.class)
	public ResponseEntity<ApiError> UsuarioNoEncontrado(NumeroException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
	@ExceptionHandler(VacioException.class)
	public ResponseEntity<ApiError> handleNumeroEncontrado(NumeroException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	@ExceptionHandler(EmailExistenteException.class)
	public ResponseEntity<ApiError> handleEmailEncontrado(EmailExistenteException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	@ExceptionHandler(DemasiadoLargoException.class)
	public ResponseEntity<ApiError> handleDemasiadoLargo(DemasiadoLargoException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
}