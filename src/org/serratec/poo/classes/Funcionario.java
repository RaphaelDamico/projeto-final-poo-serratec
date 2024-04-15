package org.serratec.poo.classes;

import java.time.LocalDate;

public class Funcionario extends Pessoa{
	private Cargo cargo;

	public Funcionario(String nome, LocalDate dataDeNascimento, String cpf, Contato contato, String senha,
			Cargo cargo) {
		super(nome, dataDeNascimento, cpf, contato, senha);
		this.cargo = cargo;
	}

	public Cargo getCargo() {
		return cargo;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("""
				Cargo: %s
				""", cargo);
	}
	
	
}
