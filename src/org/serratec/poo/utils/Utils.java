package org.serratec.poo.utils;

import org.serratec.poo.classes.Aluno;
import org.serratec.poo.classes.Contato;
import org.serratec.poo.classes.PersonalTrainer;
import org.serratec.poo.classes.Plano;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static org.serratec.poo.classes.Pessoa.getListaAlunos;
import static org.serratec.poo.classes.Pessoa.getListaPlanos;
import static org.serratec.poo.utils.LeArquivo.*;

public class Utils {
	private DateTimeFormatter fmt;
	
	public LocalDate formataDataDeNascimento(LocalDate dataDeNascimento) {
		Scanner sc = new Scanner(System.in);
		fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
		dataDeNascimento = LocalDate.parse(sc.nextLine(), fmt);
		sc.close();
		return dataDeNascimento;
	}

	public static String cadastra(){
		Scanner np = new Scanner (System.in);
		String nova = np.nextLine();
		np.close();
		return nova;
	}

	public static void novoPlano(){
		List<Plano> planos = (listaPlanos());
		System.out.println("Qual o nome do novo Plano?");
		String nomePlano = cadastra();
		System.out.println("Qual a duração do novo Plano?");
		int duracao = Integer.parseInt(cadastra());
		System.out.println("Qual o valor do novo Plano?");
		double valor = Double.parseDouble(cadastra());
		System.out.println("Qual a descrição do novo Plano?");
		String descricao = cadastra();
		Plano novoPlano =  new Plano(nomePlano, duracao, valor, descricao);
		planos.add(novoPlano);
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(getListaPlanos()))) {
			for (Plano plano : planos) {
				escritor.write(plano.toString2());
				escritor.newLine();
			}
			System.out.println("Plano cadastrado com sucesso.");
		}
		catch (IOException e) {
			System.out.println("\nErro cadastrar novo plano.");
		}
	}

	public static void novoAluno(){
		List<Aluno> alunos = (listaAluno());
		System.out.println("Nome: ");
		String nomeAluno = cadastra();
		System.out.println("Data Nascimento: ");
		String dataNascimento = cadastra();
		System.out.println("CPF: ");
		String cpf = cadastra();
		System.out.println("E-mail: ");
		String email = cadastra();
		System.out.println("Telefone: ");
		String telefone = cadastra();
		System.out.println("Senha: ");
		String senha = cadastra();
		System.out.println("Qual o plano desejado: ");
		String plano = cadastra();
		System.out.println("Data Matricula: ");
		String matricula = cadastra();
		System.out.println("Status da avaliação: ");
		String avaliacao = cadastra();
		Contato contato = new Contato(email, telefone);
		Aluno novoAluno =  new Aluno(nomeAluno, dataNascimento, cpf, contato, senha, plano, matricula, avaliacao);
		alunos.add(novoAluno);
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(getListaAlunos()))) {
			for (Aluno aluno : alunos) {
				escritor.write(aluno.toString2());
				escritor.newLine();
			}
			System.out.println("Aluno cadastrado com sucesso.");
		}
		catch (IOException e) {
			System.out.println("\nErro cadastrar novo aluno.");
		}
	}

	public static void novoPersonal(){
		List<PersonalTrainer> personais = (listaPersonal());
		System.out.println("Nome: ");
		String nomePersonal = cadastra();
		System.out.println("Data Nascimento: ");
		String dataNascimento = cadastra();
		System.out.println("CPF: ");
		String cpf = cadastra();
		System.out.println("E-mail: ");
		String email = cadastra();
		System.out.println("Telefone: ");
		String telefone = cadastra();
		System.out.println("Senha: ");
		String senha = cadastra();
		System.out.println("Especialidade: ");
		String especialidade = cadastra();
		System.out.println("Data Matricula: ");
		String cref = cadastra();
		Contato contato = new Contato(email, telefone);
		PersonalTrainer novoPersonal =  new PersonalTrainer(nomePersonal, dataNascimento, cpf, contato, senha, especialidade, cref);
		personais.add(novoPersonal);
		try (BufferedWriter escritor = new BufferedWriter(new FileWriter(getListaAlunos()))) {
			for (PersonalTrainer personalTrainer : personais) {
				escritor.write(personalTrainer.toString2());
				escritor.newLine();
			}
			System.out.println("Aluno cadastrado com sucesso.");
		}
		catch (IOException e) {
			System.out.println("\nErro cadastrar novo aluno.");
		}
	}


//	public LocalDate converteIdade(LocalDate dataDeNascimento) {
//		LocalDate dataAtual = LocalDate.now();
//		Period period = Period.between(dataDeNascimento, dataAtual);
//		return period.getYears();
//	}
}
