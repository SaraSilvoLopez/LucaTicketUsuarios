package com.example.spring.exception;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName LucaTicketUsuarioServiceApplication
 *
 * @author Jennifer Pérez y Sara Silvo
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */

public class UsuarioNoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 5L;

	/**
	 * Personaliza el mensaje de error cuando el usuario no se encuentra en la base de datos
	 */
	
	public UsuarioNoEncontradoException() {
		super("No existe el usuario");
		action1();
	}

	public UsuarioNoEncontradoException(int id) {
		super("No existe el usuario " + id);
	}

	public void action1() {

	}
}