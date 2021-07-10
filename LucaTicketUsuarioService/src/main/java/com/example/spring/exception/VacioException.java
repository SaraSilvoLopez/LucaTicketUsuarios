package com.example.spring.exception;

public class VacioException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	public VacioException() {
		super("Debes introducir todos los campos");
	}
	
	
	

}
