package org.serratec.poo.classes;

public class Login {
	private String senha;

	public Login(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return String.format("""
				Senha: %s
				""", senha);

	}

}
