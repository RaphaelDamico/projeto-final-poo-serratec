package org.serratec.poo.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PersonalTrainer extends Pessoa {
	private String especialidade;
	private String cref;
	private LocalTime horarioAtendimento;

	public PersonalTrainer(String nome, LocalDate dataDeNascimento, String cpf, Contato contato, String senha,
			String especialidade, String cref, LocalTime horarioAtendimento) {
		super(nome, dataDeNascimento, cpf, contato, senha);
		this.especialidade = especialidade;
		this.cref = cref;
		this.horarioAtendimento = horarioAtendimento;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public String getCref() {
		return cref;
	}

	public LocalTime getHorarioAtendimento() {
		return horarioAtendimento;
	}

	@Override
	public String toString() {
		DateTimeFormatter fmth = DateTimeFormatter.ofPattern("HH:mm");
		return super.toString() + String.format("""
				Especialidade: %s
				CREF: %s
				Horario de Atendimento: %s
				""", especialidade, cref, horarioAtendimento.format(fmth));
	}

	public String toString2() {
		DateTimeFormatter fmth = DateTimeFormatter.ofPattern("HH:mm");
		return super.toString2() + String.format("%s;%s;%s;", especialidade, cref, horarioAtendimento.format(fmth));
	}

}
