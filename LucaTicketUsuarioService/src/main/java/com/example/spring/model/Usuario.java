package com.example.spring.model;



import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName Usuario
 *
 * @author Jennifer Pérez
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */

/**
 * Implementamos Lombok, con @Data quedan incluidos: 
 * @Getter, @Setter, @RequiredArgsConstructor, @EqualsAndHashCode y @ToString.
 */
@Data 

/**
 * Constructor de la clase Usuario con parámetros
 *
 * @param id
 * @param nombre
 * @param apellido
 * @param mail
 * @param contrasenia
 * @param fecha_alta
 */
@AllArgsConstructor 

/**
 * Constructor de la clase Usuario vacío
 *
 */
@NoArgsConstructor

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	private String nombre;
	private String apellido;
	private String mail;
	private String contrasenia;
	private String fecha_alta;
	
}
