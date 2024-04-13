package org.serratec.poo.classes;


public class PersonalTrainer extends Pessoa {
	private String especialidade;
	private String cref;
	private Horario horarioAtendimento;

	public PersonalTrainer(String nome, String dataDeNascimento, String cpf, Contato contato, String senha,
			String especialidade, String cref) {
		super(nome, dataDeNascimento, cpf, contato, senha);
		this.especialidade = especialidade;
		this.cref = cref;
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
	public String toString2() {
		// TODO Auto-generated method stub
		return super.toString2() + String.format("%s - %s - %s -", especialidade, cref, horarioAtendimento);
	}

}
