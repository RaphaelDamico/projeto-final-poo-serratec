package org.serratec.poo.classes;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Pessoa {
	private String nome;
	private LocalDate dataDeNascimento;
	private String cpf;
	private Contato contato;
	private Login login;
	private DateTimeFormatter fmt;
	
	public Pessoa(String nome, LocalDate dataDeNascimento, String cpf, Contato contato, Login login) {
		super();
		this.nome = nome;
		this.dataDeNascimento = dataDeNascimento;
		this.cpf = cpf;
		this.contato = contato;
		this.login = login;
	}
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public LocalDate getDataDeNascimento() {
		formataDataDeNascimento();
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
	
	public void formataDataDeNascimento() {
		Scanner sc = new Scanner(System.in);
		fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println("Digite a data de nascimento (dd/MM/yyyy): ");
		dataDeNascimento = LocalDate.parse(sc.nextLine(), fmt);
		sc.close();
	}
	
	public int getIdade() {
		LocalDate dataAtual = LocalDate.now();
		Period period = Period.between(dataDeNascimento, dataAtual);
		return period.getYears();
	}
	
	@Override
	public String toString() {
		return String.format("""
				Nome: %s
				Data de nascimento: %s
				Idade: %s
				CPF: %s
				%s
				%s
				""", nome, getDataDeNascimento().format(fmt), getIdade(), cpf, contato, login);
				
	}
	
}
