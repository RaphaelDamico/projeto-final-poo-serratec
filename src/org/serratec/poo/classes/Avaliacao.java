package org.serratec.poo.classes;

public class Avaliacao {
	private Double alturaAluno;
	private Double pesoAluno;
	private Double taxaDeGordura;
	private String restricoes;
	private Aluno aluno;
	private Horario horario;
	private PersonalTrainer personalTrainer;
	public Avaliacao(Double alturaAluno, Double pesoAluno, Double taxaDeGordura, String restricoes, Aluno aluno,
			Horario horario, PersonalTrainer personalTrainer) {
		super();
		this.alturaAluno = alturaAluno;
		this.pesoAluno = pesoAluno;
		this.taxaDeGordura = taxaDeGordura;
		this.restricoes = restricoes;
		this.aluno = aluno;
		this.horario = horario;
		this.personalTrainer = personalTrainer;
	}
	public Double getAlturaAluno() {
		return alturaAluno;
	}
	public void setAlturaAluno(Double alturaAluno) {
		this.alturaAluno = alturaAluno;
	}
	public Double getPesoAluno() {
		return pesoAluno;
	}
	public void setPesoAluno(Double pesoAluno) {
		this.pesoAluno = pesoAluno;
	}
	public Double getTaxaDeGordura() {
		return taxaDeGordura;
	}
	public void setTaxaDeGordura(Double taxaDeGordura) {
		this.taxaDeGordura = taxaDeGordura;
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
	public Horario getHorario() {
		return horario;
	}
	public PersonalTrainer getPersonalTrainer() {
		return personalTrainer;
	}
	
	public Double imc() {
		return pesoAluno /Math.pow(alturaAluno, 2);
	}
	@Override
	public String toString() {
		return "Avaliacao [alturaAluno=" + alturaAluno + ", pesoAluno=" + pesoAluno + ", taxaDeGordura=" + taxaDeGordura
				+ ", restricoes=" + restricoes + ", aluno=" + aluno + ", horario=" + horario + ", personalTrainer="
				+ personalTrainer + "]";
	}
	
	
}
