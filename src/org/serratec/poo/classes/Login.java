package org.serratec.poo.classes;

import java.util.Scanner;

public class Login {
	private Pessoa pessoa;
	private String senha;
	
	public Login(Pessoa pessoa, String senha) {
		super();
		this.pessoa = pessoa;
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public String getSenha() {
		return senha;
	}

	public static void chamaLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Login: ");
		String cpf = sc.nextLine();
		System.out.print("Senha: ");
		String senha = sc.nextLine();

		sc.close();
		
		
	
	}
	
	//TODO ValidaLogin()
	

}