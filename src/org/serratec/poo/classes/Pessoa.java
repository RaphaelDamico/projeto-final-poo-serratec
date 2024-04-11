package org.serratec.poo.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.serrate.poo.utils.Utils;

public abstract class Pessoa {
	private String nome;
	private LocalDate dataDeNascimento;
	private String cpf;
	private Contato contato;
	private Login login;
	private Utils utils;

	public Pessoa(String nome, LocalDate dataDeNascimento, String cpf, Contato contato) {
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.cpf = cpf;
		this.contato = contato;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataDeNascimento() {
		LocalDate data = utils.formataDataDeNascimento(dataDeNascimento);
		return data;
	}

	public String getCpf() {
		return cpf;
	}

	public Contato getContato() {
		return contato;
	}

	public Login getLogin() {

		return login;
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
				%s
				""", nome, fmt.format(getDataDeNascimento()), cpf, contato, getLogin());

	}

}
