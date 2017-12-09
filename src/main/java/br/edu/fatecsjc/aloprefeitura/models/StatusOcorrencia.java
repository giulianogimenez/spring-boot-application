package br.edu.fatecsjc.aloprefeitura.models;

public enum StatusOcorrencia {
	ABERTA("Aberta"), APURACAO("Em apuração"), FEEDBACK("Com feedback");
	
	
	private String descricao;
	
	
	public String getDescricao() {
		return descricao;
	}



	private StatusOcorrencia(String descricao) {
		this.descricao = descricao;
	}
}
