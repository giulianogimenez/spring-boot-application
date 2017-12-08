package br.edu.fatecsjc.aloprefeitura.exceptions;

import lombok.Data;

public @Data class ApiException extends Exception {
	
	public ApiException(String message) {
		super(message);
	}
	
}
