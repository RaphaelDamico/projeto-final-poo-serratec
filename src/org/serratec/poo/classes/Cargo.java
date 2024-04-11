package org.serratec.poo.classes;

public enum Cargo {
	GERENTE("Gerente"),
	SUPERVISOR("Supervisor"),
	CONTABILIDADE("Contabilidade"),
	RECURSOS_HUMANOS("Recursos Humanos"),
	AUXILIAR_DE_SERVICOS_GERAIS("Auxiliar de Serviços Gerais"),
	TECNICO_DE_MANUTECAO_DE_EQUIPAMENTO("Técnico de Manutenção de Equipamentos"),
	PROFESSOR("Professor"),
	ATENDENTE("Atendente");
	
	private String descricaoTextual;

	private Cargo(String descricaoTextual) {
		this.descricaoTextual = descricaoTextual;
	}
	
	public String getDescricaoTextual() {
		return descricaoTextual;
	}
}
