package com.example.spring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.spring.model.Usuario;
import com.example.spring.controller.UsuarioController;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @Project LucaTicketUsuarioService
 *
 * @ClassName TestAddUsuario
 *
 * @author Sara Silvo
 *
 * @date 7 jul. 2021
 * 
 * @version 1.0
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest

public class LucaTicket_addUsuarioTest {


    @Autowired
    public UsuarioController usuarioController;
    
    @Test
    public void addUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Mariano");
        usuario.setApellido("Rubalcaba");
        usuario.setMail("rubalcaba@gmail.com");
        usuario.setContrasenia("73883b");
        usuario.setFecha_alta("2021/05/29");
        
        Usuario usuarioGuardado = usuarioController.addUsuario(usuario);
        assertThat(usuarioGuardado.getId(), equalTo(8));
    }
}
	
	
	
	
	



