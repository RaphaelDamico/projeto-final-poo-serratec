package org.serratec.poo.academia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa implements Comparable<Pessoa> {
	private String nome;
	private LocalDate dataDeNascimento;
	private String cpf;
	private Contato contato;
	private String senha;
	private static final String TXTALUNOS = "listaAlunos.txt";
	private static final String TXTPERSONAL = "listaPersonalTrainers.txt";
	private static final String TXTFUNCIONARIO = "listaFuncionarios.txt";
	private static final String TXTPLANOS = "listaPlanos.txt";
	private static final String TXTAVALIACOES = "listaAvaliacoes.txt";
	public static final String TXTAGENDAMENTOS = "listaAgendamento.txt";

	public static String getListaAlunos() {
		return TXTALUNOS;
	}

	public static String getListaPersonal() {
		return TXTPERSONAL;
	}

	public static String getListaFuncionarios() {
		return TXTFUNCIONARIO;
	}

	public static String getListaPlanos() {
		return TXTPLANOS;
	}

	public static String getListaAvaliacoes() {
		return TXTAVALIACOES;
	}

	public static String getListaAgendamento() {
		return TXTAGENDAMENTOS;
	}

	public Pessoa(String nome, LocalDate dataDeNascimento, String cpf, Contato contato, String senha) {
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.cpf = cpf;
		this.contato = contato;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataDeNascimento() {
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

	@Override
	public int compareTo(Pessoa o) {
		return this.getNome().compareTo(o.getNome());

	}
	// public int getIdade(LocalDate dataDeNascimento) {
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
				%s""", nome, dataDeNascimento.format(fmt), cpf, contato);

	}

	public String toString2() {
		return String.format("%s;%s;%s;%s;%s;", nome, dataDeNascimento, cpf, contato.toString2(),senha);
	}
}
