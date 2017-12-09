package br.edu.fatecsjc.aloprefeitura.models;

import lombok.Data;
import lombok.Getter;


public enum TipoUsuario {
	USUARIO("Usuário"), PREFEITURA("Prefeitura");
	
	private String tipo;

	public String getTipo() {
		return tipo;
	}



	private TipoUsuario(String tipo) {
		this.tipo = tipo;
	}
	
}
