package org.serratec.poo.academia;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.serratec.poo.academia.Pessoa.getListaAvaliacoes;
import static org.serratec.poo.alunos.MetodosAluno.buscaAluno;
import static org.serratec.poo.personaltrainers.MetodosPersonal.buscaPersonal;
import static org.serratec.poo.principal.Programa.sc;

public class AvaliacaoMetodos {
	public static List<Avaliacao> listaAvaliacoes() {
		List<Avaliacao> avaliacoes = new ArrayList<>();
		try {
			String diretorio = getListaAvaliacoes();
			BufferedReader txt = new BufferedReader(new FileReader(diretorio));

			String linha;
			while ((linha = txt.readLine()) != null) {
				// Processar cada linha
				String[] dados = linha.split(";");
				LocalDate dataAvaliacao = LocalDate.parse(dados[2]);
				LocalTime horaAvaliacao = LocalTime.parse(dados[3]);
				double altura = Double.parseDouble(dados[4]);
				double peso = Double.parseDouble(dados[5]);
				double taxaGordura = Double.parseDouble(dados[6]);

				Avaliacao avaliacao = new Avaliacao(dados[0], // CPF aluno
						dados[1], // Nome personal
						new Horario(dataAvaliacao, horaAvaliacao), // data e hora da avaliacao
						altura, // Altura
						peso, // Peso
						taxaGordura, // Taxa de gordura
						dados[7]);// Restrição
				avaliacoes.add(avaliacao);
			}
			txt.close();
		} catch (FileNotFoundException e) {
			System.err.println("Erro ao encontrar arquivo: " + e.getMessage());

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo " + e.getMessage());
		}
		return avaliacoes;
	}

	public static void novaAvaliacao() {
		List<Avaliacao> avaliacoes = (listaAvaliacoes());
		String cpfAluno = null;
		while (cpfAluno == null) {
			System.out.println("CPF do Aluno: ");
			sc.nextLine();
			String cpfBusca = sc.nextLine();
			String encontrado = buscaAluno(cpfBusca);
			if (encontrado == null) {
				System.out.println("Aluno não econtrado...\n");
				System.out.println("Deseja buscar um novo aluno? (S/N)");
				String op = sc.nextLine();
				if (op.equalsIgnoreCase("n")) {
					System.out.println("Retornando ao menu...");
					break;
				}
			}
			else{
				cpfAluno = cpfBusca;
				break;
			}
		}
		String nomePersonal = null;
		while (nomePersonal == null) {
			System.out.print("Personal Trainer: ");
			String nomeBusca = sc.nextLine();
			nomePersonal = buscaPersonal(nomeBusca);
			if (nomePersonal == null) {
				System.out.println("Deseja buscar um novo personal? (S/N)");
				String op = sc.nextLine();
				if (op.equalsIgnoreCase("n")) {
					System.out.println("Retornando ao menu...");
					break;
				}
			}
		}
		boolean validaData = false;
		LocalDate dataAvaliacao = null;
		while (!validaData) {
			System.out.print("Data Avaliação: ");
			String data = sc.nextLine();
			dataAvaliacao = LocalDate.parse(data);
			validaData = validaDataAvaliacao(dataAvaliacao);
			if (!validaData) {
				System.out.println("Deseja escolher uma nova data?(S/N)");
				String op = sc.nextLine();
				if (op.equalsIgnoreCase("n")) {
					System.out.println("Retornando ao menu...");
					break;
				}
			}
		}
		System.out.println("Horário: ");
		String hora = sc.nextLine();
		System.out.println("Altura do Aluno: ");
		double altura = sc.nextDouble();
		System.out.println("Peso do Aluno: ");
		double peso = sc.nextDouble();
		System.out.println("Taxa de Gordura: ");
		double taxaDeGordura = sc.nextDouble();
		sc.nextLine();
		System.out.println("Restrições: ");
		String restricoes = sc.nextLine();
		LocalTime horaAvaliacao = LocalTime.parse(hora);
		Horario horario = new Horario(dataAvaliacao, horaAvaliacao);
		Avaliacao novoAvaliacao = new Avaliacao(cpfAluno, nomePersonal, horario, altura, peso, taxaDeGordura,
				restricoes);
		avaliacoes.add(novoAvaliacao);
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(getListaAvaliacoes()))) {
			for (Avaliacao avaliacao : avaliacoes) {
				escritor.write(avaliacao.toString2());
				escritor.newLine();
			}
			System.out.println("Avaliacção cadastrada.");
		} catch (IOException e) {
			System.err.println("\nErro ao criar Avaliação.");
		}
	}

	public static List<Avaliacao> buscarAvaliacoesPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
		// Carregar as avaliações do arquivo
		List<Avaliacao> avaliacoes = listaAvaliacoes();
		List<Avaliacao> filtro = new ArrayList<>();

		// Filtrar as avaliações pelo período
		for (Avaliacao avaliacao : avaliacoes) {
			if (avaliacao.getHorario().getData().isAfter(dataInicio.minusDays(1))
					&& avaliacao.getHorario().getData().isBefore(dataFim.minusDays(1))) {
				filtro.add(avaliacao);
			}
		}
		return filtro;
	}
	
	public static boolean validaDataAvaliacao(LocalDate data) {
		LocalDate dataAtual = LocalDate.now();

		if (data.isEqual(dataAtual) || data.isBefore(dataAtual)) {
			return true;
		} else {
			System.err.println("Você não pode registrar avaliações para datas futuras.");
			return false;
		}

	}
}
