package org.serratec.poo.academia;

import static org.serratec.poo.alunos.MetodosAluno.buscaAluno;

public class Agendamento {
	private Horario horario;
	private String cpfAluno;
	private String personalTrainer;
	private Status status;

	public Agendamento(Horario horario, String cpfAluno, String personalTrainer, Status status) {
		this.horario = horario;
		this.cpfAluno = cpfAluno;
		this.personalTrainer = personalTrainer;
		this.status = status;
	}

	public Horario getHorario() {
		return horario;
	}

	public String getCPFAluno() {
		return cpfAluno;
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
				Dia: %s     Horario: %s""", buscaAluno(cpfAluno), personalTrainer, horario.getData(),
				horario.getHora());
	}

	public String toString2() {
		return String.format("%s;%s;%s;%s;%s", cpfAluno, personalTrainer, horario.getData(), horario.getHora(), status);
	}

}
