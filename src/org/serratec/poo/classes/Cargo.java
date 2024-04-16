package org.serratec.poo.classes;

public enum Cargo {
	GERENTE("Gerente"),
	AUXILIAR_DE_SERVICOS_GERAIS("Auxiliar de Serviços Gerais"),
	ATENDENTE("Atendente");
	
	private String descricaoTextual;

	private Cargo(String descricaoTextual) {
		this.descricaoTextual = descricaoTextual;
	}
	
	public String getDescricaoTextual() {
		return descricaoTextual;
	}
	
}

