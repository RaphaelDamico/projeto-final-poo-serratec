package org.serratec.poo.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.serratec.poo.utils.Utils;

public abstract class Pessoa {
	private String nome;
	private String dataDeNascimento;
	private String cpf;
	private Contato contato;
	private String senha;
	private Utils utils;
	private static final String TXTALUNOS = "C:/Users/joaop/OneDrive/Área de Trabalho/JAVA/projeto-final-poo-serratec/Lista Alunos.txt";
	private static final String TXTPERSONAL = "C:/Users/joaop/OneDrive/Área de Trabalho/JAVA/projeto-final-poo-serratec/Lista PersonalTrainers.txt";
	private static final String TXTFUNCIONARIO = "C:/Users/joaop/OneDrive/Área de Trabalho/JAVA/projeto-final-poo-serratec/Lista Funcionarios.txt";
	public static String getListaAlunos() {
	return TXTALUNOS;
	}
	public static String getListaPersonal() {
	return TXTPERSONAL;
	}
	public static String getListaFuncionarios() {
	return TXTFUNCIONARIO;
	}

	public Pessoa(String nome, String dataDeNascimento, String cpf, Contato contato, String senha) {
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.cpf = cpf;
		this.contato = contato;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public Contato getContato() {
		return contato;
	}

	public String getSenha() {
		return senha;
	}
	//	public int getIdade(LocalDate dataDeNascimento) {
//		LocalDate idade = utils.converteIdade(dataDeNascimento);
//		return getIdade(idade);
//	}

	@Override
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return String.format("""
				Nome: %s
				Data de nascimento: %s
				CPF: %s
				%s
						""", nome, dataDeNascimento, cpf, contato);

	}

}
