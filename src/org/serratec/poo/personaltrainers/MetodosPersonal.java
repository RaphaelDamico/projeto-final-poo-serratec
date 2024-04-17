package org.serratec.poo.personaltrainers;

import org.serratec.poo.academia.Agendamento;
import org.serratec.poo.academia.Avaliacao;
import org.serratec.poo.academia.Contato;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.serratec.poo.academia.AgendamentoMetodos.listaAgendamento;
import static org.serratec.poo.academia.AvaliacaoMetodos.listaAvaliacoes;
import static org.serratec.poo.academia.Pessoa.getListaAlunos;
import static org.serratec.poo.academia.Pessoa.getListaPersonal;
import static org.serratec.poo.principal.Programa.sc;

public class MetodosPersonal {
	public static List<PersonalTrainer> listaPersonal() {
		List<PersonalTrainer> personalTrainers = new ArrayList<>();
		try {
			String diretorio = getListaPersonal();
			BufferedReader txt = new BufferedReader(new FileReader(diretorio));

			String linha;
			while ((linha = txt.readLine()) != null) {
				// Processar cada linha
				String[] dados = linha.split(";");
				LocalDate nascimento = LocalDate.parse(dados[1]);

				PersonalTrainer personal = new PersonalTrainer(dados[0], // Nome
						nascimento, // Data nascimento
						dados[2], // cpf
						new Contato(dados[3], dados[4]), // contato
						dados[5], // senha
						dados[6], // especialidade
						dados[7], // cref
						dados[8]);// horario atendimento
				personalTrainers.add(personal);
			}
			txt.close();
		} catch (FileNotFoundException e) {
			System.err.println("Erro ao encontrar arquivo: " + e.getMessage());

		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo " + e.getMessage());
		}
		Collections.sort(personalTrainers);
		return personalTrainers;
	}

	public static void novoPersonal() {
		List<PersonalTrainer> personais = (listaPersonal());
		System.out.println("Nome: ");
		sc.nextLine();
		String nomePersonal = sc.nextLine();
		System.out.println("Data Nascimento: ");
		String data = sc.nextLine();
		LocalDate dataNascimento = LocalDate.parse(data);
		System.out.println("CPF: ");
		String cpf = sc.nextLine();
		System.out.println("E-mail: ");
		String email = sc.nextLine();
		System.out.println("Telefone: ");
		String telefone = sc.nextLine();
		System.out.println("Senha: ");
		String senha = sc.nextLine();
		System.out.println("Especialidade: ");
		String especialidade = sc.nextLine();
		System.out.println("CREF: ");
		String cref = sc.nextLine();
		System.out.println("Horario atendimento:");
		String horarioAtendimento = sc.nextLine();
		System.out.println("\n");
		Contato contato = new Contato(email, telefone);
		PersonalTrainer novoPersonal = new PersonalTrainer(nomePersonal, dataNascimento, cpf, contato, senha,
				especialidade, cref, horarioAtendimento);
		personais.add(novoPersonal);
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(getListaPersonal()))) {
			for (PersonalTrainer personalTrainer : personais) {
				escritor.write(personalTrainer.toString2());
				escritor.newLine();
			}
			System.out.println("Personal cadastrado com sucesso.");
		} catch (IOException e) {
			System.err.println("\nErro cadastrar novo personal.");
		}
	}

	public static void mostraPersonal() {
		List<PersonalTrainer> personais = (listaPersonal());
		for (PersonalTrainer personalTrainer : personais) {
			System.out.println(personalTrainer);
		}
	}

	public static void visualizarAvaliacoesPersonal(String nome) {
		List<Avaliacao> avaliacoes = listaAvaliacoes();
		List<Avaliacao> avaliacoesRealizadas = avaliacoes.stream()
				.filter(a -> a.getNomePersonal().equalsIgnoreCase(nome)).toList();
		for (Avaliacao avaliacao : avaliacoesRealizadas) {
			System.out.println(avaliacao);
		}
	}

	public static void visualizarAgendamentosPersonal(String nome) {
		List<Agendamento> agendamentos = listaAgendamento();
		List<Agendamento> agendamentosRealizados = agendamentos.stream()
				.filter(a -> a.getPersonalTrainer().equalsIgnoreCase(nome)).toList();
		for (Agendamento agendamento : agendamentosRealizados) {
			System.out.println(agendamento);
		}
	}

	public static String buscaPersonal(String nomePersonal) {
		List<PersonalTrainer> personalTrainers = (listaPersonal());
		boolean encontrado = false;
		for (PersonalTrainer personalTrainer : personalTrainers) {
			if (personalTrainer.getNome().contains(nomePersonal)) {
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			nomePersonal = null;
			System.out.println("Profissional não cadastrado!");
		}
		return nomePersonal;
	}
}
