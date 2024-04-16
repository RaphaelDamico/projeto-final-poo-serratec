package org.serratec.poo.personaltrainers;

import org.serratec.poo.academia.Menu;

import static org.serratec.poo.academia.AvaliacaoMetodos.novaAvaliacao;
import static org.serratec.poo.personaltrainers.MetodosPersonal.*;

public class MenuPersonal implements Menu {
	private PersonalTrainer personalTrainer;

	public MenuPersonal(PersonalTrainer personalTrainer) {
		this.personalTrainer = personalTrainer;
	}

	public PersonalTrainer getPersonalTrainer() {
		return personalTrainer;
	}

	@Override
	public void exibeMenu() {
		System.out.printf("""
				1 - Visualizar agenda de atendimentos
				2 - Registrar avaliações físicas dos alunos.
				3 - Visualizar lista de avaliações realizadas
				4 - Sair
				""");
	}

	@Override
	public void escolhaMenu(int opcao) {
		switch (opcao) {
		case 1:
			// Visualizar agenda de atendimentos.
			exibe(1);
			break;
		case 2:
			// Registrar avaliações físicas dos alunos.
			cadastra(1);
			break;
		case 3:
			// Visualizar lista de avaliações realizadas.
			exibe(2);
			break;
		case 4:
			break;
		default:
			System.out.println("Digite uma opção válida...\n");
			break;
		}
	}

	@Override
	public void exibe(int opcao) {
		if (opcao == 1) {
			visualizarAgendamentosPersonal(getPersonalTrainer().getNome());
		}
		if (opcao == 2) {
			visualizarAvaliacoesPersonal(getPersonalTrainer().getNome());
		}
	}

	@Override
	public void buscaAgendamento() {

	}

	@Override
	public void buscaAvaliacao() {

	}

	@Override
	public void cadastra(int opcao) {
		novaAvaliacao();
	}

	@Override
	public void remove() {

	}
}
