package org.serratec.poo.classes;

import java.time.LocalDate;

public class PersonalTrainer extends Pessoa {
	private String especialidade;
	private String cref;
	private Horario horarioAtendimento;

	public PersonalTrainer(String nome, LocalDate dataDeNascimento, String cpf, Contato contato, Login login,
			String especialidade, String cref, Horario horarioAtendimento, String senha) {
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

	public Horario getHorarioAtendimento() {
		return horarioAtendimento;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + String.format("""
				Especialidade: %s
				CREF: %s
				Horario de Atendimento: %s
				""", especialidade, cref, horarioAtendimento);
	}

}
