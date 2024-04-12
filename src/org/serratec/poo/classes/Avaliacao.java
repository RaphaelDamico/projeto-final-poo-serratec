package org.serratec.poo.classes;

public class Avaliacao {
	private String nomePersonal;
	private Horario horario;
	private double alturaAluno;
	private double pesoAluno;
	private double taxaDeGordura;
	private String restricoes;

	public Avaliacao(String nomePersonal, Horario horario, double alturaAluno,
			double pesoAluno, double taxaDeGordura, String restricoes) {
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

	public void setPesoAluno(Double pesoAluno) {
		this.pesoAluno = pesoAluno;
	}

	public String getRestricoes() {
		return restricoes;
	}

	public void setRestricoes(String restricoes) {
		this.restricoes = restricoes;
	}


	public String getPersonal() {
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
				Aluno: 
				Personal trainer: %s
				Horario: %s Horas
				Altura: %.2f Metros
				Peso: %.2f KG
				Taxa de gordura: %.2f
				Restrições: %s
				""", nomePersonal, horario, alturaAluno, pesoAluno, taxaDeGordura, restricoes);
	}

}
