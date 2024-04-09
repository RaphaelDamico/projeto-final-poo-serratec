package org.serratec.poo.classes;

import java.time.LocalDate;
import java.time.Period;

public abstract class Pessoa {
	private String nome;
	private LocalDate dataDeNascimento;
	private String cpf;
	private Contato contato;
	private Login login;
	
	public Pessoa(String nome, LocalDate dataDeNascimento, String cpf, Contato contato, Login login) {
		super();
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.cpf = cpf;
		this.contato = contato;
		this.login = login;
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
	public Login getLogin() {
		return login;
	}
	
	public int getIdade() {
		LocalDate dataAtual = LocalDate.now();
		Period period = Period.between(dataDeNascimento, dataAtual);
		return period.getYears();
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome +  ", Data de Nascimento=" + dataDeNascimento + ", Idade=" + getIdade() + ", cpf=" + cpf + ", contato="
				+ contato + ", login=" + login + "]";
	}
	
}
