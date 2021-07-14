package com.example.spring.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring.exception.DemasiadosCaracteresException;
import com.example.spring.exception.EmailExistenteException;
import com.example.spring.exception.TipoCaracteresException;
import com.example.spring.exception.UsuarioNoEncontradoException;
//import com.example.spring.exception.UsuarioNoEncontradoException;
import com.example.spring.exception.VacioException;
import com.example.spring.model.Usuario;
import com.example.spring.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName UsuarioServiceImpl
 *
 * @author Jennifer Pérez
 *
 * @date 7 jul. 2021
 *
 * @version 1.0
 */

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	private final PasswordEncoder encoder;

	/**
	 * Instancia UsuarioRepository repo
	 */

	@Autowired
	private UsuarioRepository repo;

	/**
	 * Implementación/Sobrescritura del método save Con la estructura if
	 *
	 * @param usuario
	 * @return
	 */

	@Override
	public Usuario save(Usuario usuario) {

		if (usuario.getNombre() != null && usuario.getApellido() != null && usuario.getContrasenia() != null
				&& usuario.getMail() != null) {
			if (usuario.getNombre().length() <= 50 && usuario.getApellido().length() <= 50
					&& usuario.getContrasenia().length() <= 50 && usuario.getMail().length() <= 50) {
				if (contieneSoloLetras(usuario.getNombre()) && contieneSoloLetras(usuario.getApellido())) {
					usuario.setContrasenia(encoder.encode(usuario.getPassword()));
					usuario.setRol("USER");
					try {
						usuario.setFecha_alta(LocalDateTime.now());
						return this.repo.save(usuario);
					} catch (DataIntegrityViolationException ex) {
						throw new EmailExistenteException();
					}
				} else {
					throw new TipoCaracteresException();
				}
			} else {
				throw new DemasiadosCaracteresException();
			}
		} else {

			throw new VacioException();
		}
	}

	public static boolean contieneSoloLetras(String cadena) {
		for (int x = 0; x < cadena.length(); x++) {
			char c = cadena.charAt(x);
			if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
				return false;
			}
		}
		return true;
	}

	public Optional<Usuario> findByMail(String mail) {
		return repo.findByMail(mail);
	}

	public Optional<Usuario> findById(int id) {
		if (repo.existsById(id)) {
			return repo.findById(id);
		} else {
			throw new UsuarioNoEncontradoException();
		}
	}

	@Override
	public List<Usuario> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Usuario> edit(Usuario usuario) {
		if (repo.existsById(usuario.getId())) {
			repo.editar(usuario.getNombre(), usuario.getApellido(), usuario.getId(), usuario.getMail(),
					usuario.getContrasenia());
			return repo.findById(usuario.getId());
		} else {
			throw new UsuarioNoEncontradoException();
		}
	}

	@Override
	public void deleteById(int id) {
		repo.deleteById(id);
	}

}