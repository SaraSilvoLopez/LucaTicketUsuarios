package com.example.spring.exception;

public class NumeroException extends RuntimeException{
	private static final long serialVersionUID = 2L;

	public NumeroException() {
		super("El nombre no puede contener números");
	}
}