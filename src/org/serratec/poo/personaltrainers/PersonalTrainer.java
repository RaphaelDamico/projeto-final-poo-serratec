package org.serratec.poo.personaltrainers;

import org.serratec.poo.academia.Contato;
import org.serratec.poo.academia.Pessoa;

import java.time.LocalDate;

public class PersonalTrainer extends Pessoa {
	private String especialidade;
	private String cref;
	private String horarioAtendimento;

	public PersonalTrainer(String nome, LocalDate dataDeNascimento, String cpf, Contato contato, String senha,
			String especialidade, String cref, String horarioAtendimento) {
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

	public String getHorarioAtendimento() {
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

	public String toString2() {
		return super.toString2() + String.format("%s;%s;%s;", especialidade, cref, horarioAtendimento);
	}

}
