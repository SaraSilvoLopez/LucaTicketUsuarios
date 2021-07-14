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

public class VacioException extends RuntimeException {

	/**
	 * Personaliza el mensaje de error cuando no se completa uno de los campos obligatorios
	 */
	private static final long serialVersionUID = 2L;

	public VacioException() {
		super("No puede quedar ningún campo vacío");
	}

}
