package org.serratec.poo.classes;

public class Avaliacao {
	private Aluno aluno;
	private PersonalTrainer personalTrainer;
	private Horario horario;
	private double alturaAluno;
	private double pesoAluno;
	private double taxaDeGordura;
	private String restricoes;

	public Avaliacao(Aluno aluno, PersonalTrainer personalTrainer, Horario horario, double alturaAluno,
			double pesoAluno, double taxaDeGordura, String restricoes) {
		this.aluno = aluno;
		this.personalTrainer = personalTrainer;
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

	public Aluno getAluno() {
		return aluno;
	}

	public PersonalTrainer getPersonalTrainer() {
		return personalTrainer;
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
				Horario: %s Horas
				Altura: %.2f Metros
				Peso: %.2f KG
				Taxa de gordura: %.2f
				Restrições: %s
				""", aluno, personalTrainer, horario, alturaAluno, pesoAluno, taxaDeGordura, restricoes);
	}

}
