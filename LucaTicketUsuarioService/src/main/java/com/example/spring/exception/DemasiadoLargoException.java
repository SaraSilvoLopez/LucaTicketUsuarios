package com.example.spring.exception;

public class DemasiadoLargoException extends RuntimeException {
	private static final long serialVersionUID = 4L;

	public DemasiadoLargoException() {
		super("No puede contener tantos caracteres");
	}

}
