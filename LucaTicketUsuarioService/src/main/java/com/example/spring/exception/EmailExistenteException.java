package com.example.spring.exception;

public class EmailExistenteException extends RuntimeException {
	//RuntimeException es una clase que representa las excepciones que ocurren dentro 
	//de la máquina virtual Java (durante el tiempo de ejecución).
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	//Recordar: Serializar es como comprimir. 
	//serialVersionUID hay que ponerlo siempre así. Es el número de versión para esa clase.
	
	public EmailExistenteException() {
		super("El email introducido ya se encuentra en la base de datos");
	}
	

}
