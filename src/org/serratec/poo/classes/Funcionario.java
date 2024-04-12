package org.serratec.poo.classes;

public class Funcionario extends Pessoa{
	private Cargo cargo;

	public Funcionario(String nome, String dataDeNascimento, String cpf, Contato contato, String senha,
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
