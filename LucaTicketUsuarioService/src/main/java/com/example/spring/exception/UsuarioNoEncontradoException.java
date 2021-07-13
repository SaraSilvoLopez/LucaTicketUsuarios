package com.example.spring.exception;



public class UsuarioNoEncontradoException extends RuntimeException{

private static final long serialVersionUID = 5L;



public UsuarioNoEncontradoException() {
super("No existe el usuario");
action1();
}
public UsuarioNoEncontradoException(int id) {
super("No existe el usuario "+id);
}
public void action1() {

}
}