package com.example.spring.error;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.spring.exception.DemasiadosCaracteres;
import com.example.spring.exception.EmailExistenteException;
import com.example.spring.exception.TipoCaracteresException;
import com.example.spring.exception.VacioException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler{
	
	//La anotación @ExceptionHandler se encargará de anotar un método como el 
	//encargado de realizar acciones en caso de que se lance una excepción.
	//handleJasonMappingException, maneja los errores de parseo de valores al crear/editar
	//un usuario (JsonMappingException).
	
	@ExceptionHandler(JsonMappingException.class)
	public ResponseEntity<ApiError> handleJsonMappingException(JsonMappingException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
		
	@ExceptionHandler(TipoCaracteresException.class)
	public ResponseEntity<ApiError> UsuarioNoEncontrado(TipoCaracteresException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
	@ExceptionHandler(VacioException.class)
	public ResponseEntity<ApiError> handleNumeroEncontrado(TipoCaracteresException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	@ExceptionHandler(EmailExistenteException.class)
	public ResponseEntity<ApiError> handleEmailEncontrado(EmailExistenteException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	@ExceptionHandler(DemasiadosCaracteres.class)
	public ResponseEntity<ApiError> handleDemasiadoLargo(DemasiadosCaracteres ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
	HttpStatus status, WebRequest request) {
	ApiError apiError = new ApiError(status, ex.getMessage());
	return ResponseEntity.status(status).headers(headers).body(apiError);
	}
}