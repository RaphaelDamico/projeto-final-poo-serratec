package org.serratec.poo.alunos;

import org.serratec.poo.academia.Avaliacao;
import org.serratec.poo.academia.Contato;
import org.serratec.poo.academia.Pessoa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno extends Pessoa {
	private String plano;
	private LocalDate dataMatricula;
	private String statusAvaliacao;

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

	@Override
	public String toString() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return super.toString() + String.format("""
				Plano contratado: %s
				Data de matrícula: %s
				""", plano, dataMatricula.format(fmt));
	}

	public String toString2() {
		return super.toString2() + String.format("%s;%s;", plano, dataMatricula);
	}
}
