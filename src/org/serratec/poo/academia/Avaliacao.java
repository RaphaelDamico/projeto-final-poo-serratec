package org.serratec.poo.academia;

import static org.serratec.poo.alunos.MetodosAluno.buscaAluno;

public class Avaliacao {
	private String cpfAluno;
	private String nomePersonal;
	private Horario horario;
	private double alturaAluno;
	private double pesoAluno;
	private double taxaDeGordura;
	private String restricoes;

	public Avaliacao(String cpfAluno, String nomePersonal, Horario horario, double alturaAluno, double pesoAluno,
			double taxaDeGordura, String restricoes) {
		this.cpfAluno = cpfAluno;
		this.nomePersonal = nomePersonal;
		this.horario = horario;
		this.alturaAluno = alturaAluno;
		this.pesoAluno = pesoAluno;
		this.taxaDeGordura = taxaDeGordura;
		this.restricoes = restricoes;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public double getAlturaAluno() {
		return alturaAluno;
	}

	public void setAlturaAluno(Double alturaAluno) {
		this.alturaAluno = alturaAluno;
	}

	public double getPesoAluno() {
		return pesoAluno;
	}

	public String getRestricoes() {
		return restricoes;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public String getNomePersonal() {
		return nomePersonal;
	}

	public double getTaxaDeGordura() {
		return taxaDeGordura;
	}

	public double imc() {
		return pesoAluno / Math.pow(alturaAluno, 2);
	}

	@Override
	public String toString() {
		return String.format("""
				Aluno: %s
				Personal trainer: %s
				Data: %s Hora: %s
				Altura: %.2f Metros
				Peso: %.2f KG
				Taxa de gordura: %.2f
				Imc: %.2f
				Restrições: %s
				""", buscaAluno(cpfAluno), nomePersonal, horario.getData(), horario.getHora(), alturaAluno, pesoAluno,
				taxaDeGordura, imc(), restricoes);
	}

	public String toString2() {
		return String.format("%s;%s;%s;%s;%s;%s;%s;%s", cpfAluno, nomePersonal, horario.getData(), horario.getHora(),
				alturaAluno, pesoAluno, taxaDeGordura, restricoes);
	}
}
