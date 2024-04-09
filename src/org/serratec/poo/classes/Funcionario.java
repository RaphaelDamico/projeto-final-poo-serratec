package org.serratec.poo.classes;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
	private String cargo;

	public Funcionario(String nome, LocalDate dataDeNascimento, String cpf, Contato contato, Login login,
			String cargo) {
		super(nome, dataDeNascimento, cpf, contato, login);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + "]";
	}
	
	
}
