package org.serratec.poo.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno extends Pessoa {
	private String plano;
	private LocalDate dataMatricula;
	private Avaliacao avaliacao;
	private String statusAvaliacao;

	public Aluno(String nome, LocalDate dataDeNascimento, String cpf, Contato contato, String senha, String plano,
				 LocalDate dataMatricula, String statusAvaliacao) {
		super(nome, dataDeNascimento, cpf, contato, senha);
		this.plano = plano;
		this.dataMatricula = dataMatricula;
		this.statusAvaliacao = statusAvaliacao;
	}
	public Aluno(String nome, LocalDate dataDeNascimento, String cpf, Contato contato, String senha, String plano,
			LocalDate dataMatricula) {
		super(nome, dataDeNascimento, cpf, contato, senha);
		this.plano = plano;
		this.dataMatricula = dataMatricula;
	}

	public String getPlano() {
		return plano;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}
	
	public String getStatusAvaliacao() {
		return statusAvaliacao;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return super.toString() + String.format("""
				Plano contratado: %s
				Data de matrícula: %s
				Avaliação: %s
				""", plano, dataMatricula.format(fmt), statusAvaliacao);
	}
	public String toString2() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return super.toString2() + String.format("%s;%s;%s;", plano, dataMatricula.format(fmt), avaliacao);
	}
}
