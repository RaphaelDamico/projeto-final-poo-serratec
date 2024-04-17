package org.serratec.poo.funcionarios;

import static org.serratec.poo.academia.AvaliacaoMetodos.buscarAvaliacoesPorPeriodo;
import static org.serratec.poo.academia.PlanoMetodos.mostraPlanos;
import static org.serratec.poo.academia.PlanoMetodos.novoPlano;
import static org.serratec.poo.alunos.MetodosAluno.listaAluno;
import static org.serratec.poo.alunos.MetodosAluno.novoAluno;
import static org.serratec.poo.funcionarios.MetodosFuncionario.listaFuncionario;
import static org.serratec.poo.personaltrainers.MetodosPersonal.listaPersonal;
import static org.serratec.poo.personaltrainers.MetodosPersonal.novoPersonal;
import static org.serratec.poo.principal.Programa.sc;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.serratec.poo.academia.Avaliacao;
import org.serratec.poo.academia.Menu;
import org.serratec.poo.academia.Pessoa;
import org.serratec.poo.alunos.Aluno;

public class MenuFuncionario implements Menu {
	private Funcionario funcionario;

	public MenuFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	@Override
	public void exibeMenu() {
		System.out.printf("""
				1 - Cadastrar novo plano
				2 - Cadastrar novo aluno
				3 - Cadastrar novo Personal Trainer
				4 - Emitir relatório de planos
				5 - Emitir relatório de alunos
				6 - Emitir relatório de equipe
				7 - Emitir relação de avaliações físicas por período
				8 - Sair
				""");
	}

	@Override
	public void escolhaMenu(int opcao) {
		switch (opcao) {
		case 1:
			// Cadastrar novo plano
			cadastra(1);
			break;
		case 2:
			// Cadastrar novo aluno
			cadastra(2);
			break;
		case 3:
			// Cadastrar novo Personal Trainer
			cadastra(3);
			break;
		case 4:
			// Emtir relatório de planos
			exibe(4);
			break;
		case 5:
			// Emitir relatório de alunos
			exibe(5);
			break;
		case 6:
			// Emitir relatório de equipe (funcionários e personal trainers)
			exibe(6);
			break;
		case 7:
			// Emitir relação de avaliações físicas por período
			exibe(7);
			break;
		case 8:
			// Sair
			break;
		default:
			System.out.println("Digite uma opção válida...\n");
			break;
		}
	}

	@Override
	public void exibe(int opcao) {
		if (opcao == 4) {
			mostraPlanos();
		}
		if (opcao == 5) {
			List<Aluno> alunos = (listaAluno());
			for (Aluno aluno : alunos) {
				System.out.println(aluno);
			}
		}
		if (opcao == 6) {
			List<Pessoa> listaCombinada = Stream.concat(listaFuncionario().stream(), listaPersonal().stream())
					.collect(Collectors.toList());
			for (Pessoa pessoa : listaCombinada) {
				System.out.println(pessoa);
			}
		}
		if (opcao == 7) {
			System.out.println("Insira a data do inicio do periodo (yyyy-MM-dd): ");
			sc.nextLine();
			String dataI = sc.nextLine();
			LocalDate dataInicio = LocalDate.parse(dataI);
			System.out.println("Insira a data do fim do periodo (yyyy-MM-dd): ");
			String dataF = sc.nextLine();
			LocalDate dataFim = LocalDate.parse(dataF);
			List<Avaliacao> filtro = buscarAvaliacoesPorPeriodo(dataInicio, dataFim);
			if (filtro.isEmpty()){
				System.err.println("Não foram encontradas avaliações para este período.");
			}
			else{
				for (Avaliacao avaliacao : filtro) {
					System.out.println(avaliacao);
				}
			}
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
		if (opcao == 1) {
			novoPlano();
		}
		if (opcao == 2) {
			novoAluno();
		}
		if (opcao == 3) {
			novoPersonal();
		}
	}

	@Override
	public void remove() {

	}
}
