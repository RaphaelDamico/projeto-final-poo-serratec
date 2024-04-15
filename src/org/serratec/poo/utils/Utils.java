package org.serratec.poo.utils;

import static org.serratec.poo.classes.Pessoa.getListaAlunos;
import static org.serratec.poo.classes.Pessoa.getListaPlanos;
import static org.serratec.poo.utils.LeArquivo.listaAluno;
import static org.serratec.poo.utils.LeArquivo.listaAvaliacoes;
import static org.serratec.poo.utils.LeArquivo.listaPersonal;
import static org.serratec.poo.utils.LeArquivo.listaPlanos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import org.serratec.poo.classes.Pessoa;
import org.serratec.poo.classes.Aluno;
import org.serratec.poo.classes.Avaliacao;
import org.serratec.poo.classes.Contato;
import org.serratec.poo.classes.PersonalTrainer;
import org.serratec.poo.classes.Plano;

public class Utils {
	//private static DateTimeFormatter fmt;
	
	/*public static LocalDate formataData(LocalDate data) {
		Scanner sc = new Scanner(System.in);
		fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		data = LocalDate.parse(sc.nextLine(), fmt);
		sc.close();
		return data;
	}*/

	public static void novoPlano(){
		Scanner sc = new Scanner(System.in);
		List<Plano> planos = (listaPlanos());
		System.out.println("Qual o nome do novo Plano?");
		String nomePlano = sc.nextLine();
		System.out.println("Qual a duração do novo Plano?");
		int duracao = sc.nextInt();
		System.out.println("Qual o valor do novo Plano?");
		double valor = sc.nextDouble();
		System.out.println("Qual a descrição do novo Plano?");
		String descricao = sc.nextLine();
		System.out.println("\n");
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
		sc.close();
	}

	public static void novoAluno(){
		Scanner sc = new Scanner(System.in);
		List<Aluno> alunos = (listaAluno());
		System.out.println("Nome: ");
		String nomeAluno = sc.nextLine();
		System.out.println("Data Nascimento: ");
		LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
		System.out.println("CPF: ");
		String cpf = sc.nextLine();
		System.out.println("E-mail: ");
		String email = sc.nextLine();
		System.out.println("Telefone: ");
		String telefone = sc.nextLine();
		System.out.println("Senha: ");
		String senha = sc.nextLine();
		System.out.println("Qual o plano desejado: ");
		String plano = sc.nextLine();
		System.out.println("Data Matricula: ");
		LocalDate matricula = LocalDate.parse(sc.nextLine());
		System.out.println("\n");
		Contato contato = new Contato(email, telefone);
		Aluno novoAluno =  new Aluno(nomeAluno, dataNascimento, cpf, contato, senha, plano, matricula);
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
		sc.close();
	}

	public static void novoPersonal(){
		Scanner sc = new Scanner(System.in);
		List<PersonalTrainer> personais = (listaPersonal());
		System.out.println("Nome: ");
		String nomePersonal = sc.nextLine();
		System.out.println("Data Nascimento: ");
		LocalDate dataNascimento = LocalDate.parse(sc.nextLine());
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
		System.out.println("Data Matricula: ");
		String cref = sc.nextLine();
		System.out.println("Horario atendimento:");
		String horarioAtendimento = sc.nextLine();
		System.out.println("\n");
		Contato contato = new Contato(email, telefone);
		PersonalTrainer novoPersonal =  new PersonalTrainer(nomePersonal, dataNascimento, cpf, contato, senha, especialidade, cref, horarioAtendimento);
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
		sc.close();
	}
	
	public static void novaAvaliacao() {
		Scanner sc = new Scanner(System.in);
		List<Avaliacao> avaliacoes = listaAvaliacoes();
		
		sc.close();
	}

	public static void mostraPlanos(){
		List<Plano> planos = (listaPlanos());
		for (Plano plano : planos){
			System.out.println(plano);
		}
	}
	public static void mostraPersonal(){
		List<PersonalTrainer> personais = (listaPersonal());
		for (PersonalTrainer personalTrainer : personais){
			System.out.println(personalTrainer);
		}
	}
	
	
	
	public static void visualizarAvaliacoesRealizadas(String nome) {
		List<Avaliacao> avaliacoes = listaAvaliacoes();
		List<Avaliacao> avaliacoesRealizadas = avaliacoes.stream()
				.filter(a -> a.getNomePersonal().equalsIgnoreCase(nome)).toList();
		System.out.println(avaliacoesRealizadas);
	}

}
