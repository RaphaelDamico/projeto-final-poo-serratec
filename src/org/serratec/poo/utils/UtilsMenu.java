package org.serratec.poo.utils;

public class UtilsMenu {
	public static String exibeMenuAluno() {
		return String.format("""
				1 - Visualizar dados e plano
				2 - Solicitar agendamento com o personal
				3 - Visualizar histórico de agendamentos
				4 - Cancelar agendamento
				5 - Visualizar avaliações físicas
				6 - Sair
				""");
	}
	public static String exibeMenuPersonal() {
		return String.format("""
				1 - Visualizar agenda de atendimentos
				2 - Registrar avaliações físicas dos alunos.
				3 - Visualizar lista de avaliações realizadas 
				4 - Sair
				""");
	}
	public static String exibeMenuFuncionario() {
		return String.format("""
				1 - Cadastrar novo plano
				2 - Cadastrar novo aluno
				3 - Cadastrar novo Personal Trainer
				4 - Emitir relatório de planos
				5 - Emitir relatório de equipe
				6 - Emitir relação de avaliações físicar por período
				7 - Sair
				""");
	}
}
