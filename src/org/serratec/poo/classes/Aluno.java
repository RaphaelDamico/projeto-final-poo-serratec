package org.serratec.poo.classes;

public class Aluno extends Pessoa {
	private String plano;
	private String dataMatricula;
	private String avaliacao;

	public Aluno(String nome, String dataDeNascimento, String cpf, Contato contato, String senha, String plano,
				 String dataMatricula, String avaliacao) {
		super(nome, dataDeNascimento, cpf, contato, senha);
		this.plano = plano;
		this.dataMatricula = dataMatricula;
	}

	public String getPlano() {
		return plano;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public String getAvaliacao() {
		return avaliacao;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("""
				Plano contratado:%s
				Data de matrícula:%s
				Avaliação:%.2f
				""", plano, dataMatricula, avaliacao);
	}
	public String toString2() {
		return super.toString2() + String.format("%s - %s - %s -", plano, dataMatricula, avaliacao);
	}
}
