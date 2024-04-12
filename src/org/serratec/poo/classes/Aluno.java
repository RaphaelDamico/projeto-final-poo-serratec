package org.serratec.poo.classes;

import java.time.LocalDate;

public class Aluno extends Pessoa {
	private Plano plano;
	private String dataMatricula;
	private Avaliacao avaliacao;

	public Aluno(String nome, String dataDeNascimento, String cpf, Contato contato, String senha, Plano plano,
			String dataMatricula) {
		super(nome, dataDeNascimento, cpf, contato, senha);
		this.plano = plano;
		this.dataMatricula = dataMatricula;
	}


	public Plano getPlano() {
		return plano;
	}

	public String getDataMatricula() {
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
