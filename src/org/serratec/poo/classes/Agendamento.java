package org.serratec.poo.classes;

public class Agendamento {
	private Horario horario;
	private String aluno;
	private String personalTrainer;
	private Status status;

	public Agendamento(Horario horario, String aluno, String personalTrainer, Status status) {
		super();
		this.horario = horario;
		this.aluno = aluno;
		this.personalTrainer = personalTrainer;
		this.status = status;
	}

	public Horario getHorario() {
		return horario;
	}

	public String getAluno() {
		return aluno;
	}

	public String getPersonalTrainer() {
		return personalTrainer;
	}
	
	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return String.format("""
				Aluno: %s
				Personal: %s
				Dia: %s     Horario: %s""", aluno, personalTrainer, horario.getData(), horario.getHora());
	}

	public String toString2() {
		return String.format("%s;%s;%s;%s", aluno, personalTrainer, horario.getData(), horario.getHora());
	}
}
