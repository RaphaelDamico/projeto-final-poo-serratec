package org.serratec.poo.alunos;

import org.serratec.poo.academia.Agendamento;
import org.serratec.poo.academia.Menu;

import java.util.ArrayList;
import java.util.List;

import static org.serratec.poo.academia.AgendamentoMetodos.listaAgendamento;
import static org.serratec.poo.academia.AgendamentoMetodos.novoAgendamento;
import static org.serratec.poo.alunos.MetodosAluno.visualizarAgendamentosAluno;
import static org.serratec.poo.alunos.MetodosAluno.visualizarAvaliacoesAluno;
import static org.serratec.poo.principal.Programa.sc;

public class MenuAluno implements Menu {
	private Aluno aluno;

	public MenuAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	@Override
	public void exibeMenu() {
		System.out.println("""
				1 - Visualizar dados e plano
				2 - Solicitar agendamento com o personal
				3 - Visualizar histórico de agendamentos
				4 - Cancelar agendamento
				5 - Visualizar avaliações físicas
				6 - Sair
				""");
	}

	@Override
	public void escolhaMenu(int opcao) {
		switch (opcao) {
		case 1:
			// Visualizar dados pessoais e plano contratado.
			exibe(1);
			break;
		case 2:
			// Solicitar agendamento de horário com personal trainer.
			cadastra(1);
			break;
		case 3:
			// Visualizar histórico de agendamentos.
			buscaAgendamento();
			break;
		case 4:
			// Cancelar agendamento.
			remove();
			break;
		case 5:
			// Visualizar avaliações físicas.
			buscaAvaliacao();
			break;
		case 6:
			break;
		default:
			System.out.println("Digite uma opção válida...\n");
			break;
		}
	}

	@Override
	public void exibe(int opcao) {
		System.out.println(getAluno());
	}

	@Override
	public void cadastra(int opcao) {
		novoAgendamento(getAluno().getCpf());
	}

	@Override
	public void buscaAgendamento() {
		visualizarAgendamentosAluno(getAluno().getCpf());
	}

	public void remove() {
		List<Agendamento> agendamentos = visualizarAgendamentosAluno(getAluno().getCpf());
		System.out.println("Qual agendamento deseja cancelar?\n");
		System.out.println("Digite o índice da avaliação desejada:");
		int op = sc.nextInt();
		sc.nextLine();
		if (op<1 || op>agendamentos.size()){
			System.out.println("Digite um valor valido!\n");
			remove();
		}
		agendamentos.remove(op-1);
		System.out.println("Agendamento cancelado com sucesso!");
	}

	public void buscaAvaliacao() {
		visualizarAvaliacoesAluno(getAluno().getCpf());
	}
}
