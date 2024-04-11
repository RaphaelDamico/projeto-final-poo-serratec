package org.serratec.poo.classes;

import java.time.LocalDate;

public class Aluno extends Pessoa {
	private Plano plano;
	private LocalDate dataMatricula;
	private Avaliacao avaliacao;

	public Aluno(String nome, LocalDate dataDeNascimento, String cpf, Contato contato, Login login, Plano plano,
			LocalDate dataMatricula, Avaliacao avaliacao) {
		super(nome, dataDeNascimento, cpf, contato);
		this.plano = plano;
		this.dataMatricula = dataMatricula;
		this.avaliacao = avaliacao;
	}

	public Plano getPlano() {
		return plano;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("""
				Plano contratado: %s
				Data de matrícula: %s
				Avaliação: %.2f
				""", plano, dataMatricula, avaliacao);
	}

}
